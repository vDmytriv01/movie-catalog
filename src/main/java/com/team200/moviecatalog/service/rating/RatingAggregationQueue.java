package com.team200.moviecatalog.service.rating;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RatingAggregationQueue {

    private final MovieRatingUpdater movieRatingUpdater;

    private final BlockingQueue<Long> queue = new LinkedBlockingQueue<>();
    private final Set<Long> pending = ConcurrentHashMap.newKeySet();
    private final Set<Long> dirty = ConcurrentHashMap.newKeySet();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private ExecutorService worker;

    public void enqueue(Long movieId) {
        if (movieId == null) {
            return;
        }
        if (pending.add(movieId)) {
            queue.offer(movieId);
        } else {
            dirty.add(movieId);
        }
    }

    @PostConstruct
    void start() {
        running.set(true);
        worker = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "rating-aggregation-worker");
            t.setDaemon(true);
            return t;
        });
        worker.submit(this::runLoop);
    }

    @PreDestroy
    void shutdown() {
        running.set(false);
        if (worker != null) {
            worker.shutdownNow();
        }
    }

    private void runLoop() {
        while (running.get() || !queue.isEmpty()) {
            try {
                Long movieId = queue.poll(1, TimeUnit.SECONDS);
                if (movieId == null) {
                    continue;
                }
                process(movieId);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception ex) {
                log.error("Rating aggregation worker failed", ex);
            }
        }
    }

    private void process(Long movieId) {
        try {
            movieRatingUpdater.recalculateAndSaveAggregates(movieId);
        } finally {
            pending.remove(movieId);
            if (dirty.remove(movieId)) {
                enqueue(movieId);
            }
        }
    }
}
