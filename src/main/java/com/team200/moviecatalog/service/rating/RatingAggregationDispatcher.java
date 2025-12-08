package com.team200.moviecatalog.service.rating;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
@RequiredArgsConstructor
public class RatingAggregationDispatcher {

    private final RatingAggregationQueue queue;

    public void schedule(@Nonnull Long movieId) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(
                    new TransactionSynchronization() {
                        @Override
                        public void afterCommit() {
                            queue.enqueue(movieId);
                        }
                    }
            );
        } else {
            queue.enqueue(movieId);
        }
    }
}
