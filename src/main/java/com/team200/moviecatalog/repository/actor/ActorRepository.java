package com.team200.moviecatalog.repository.actor;

import com.team200.moviecatalog.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    boolean existsByFullNameIgnoreCase(String fullName);
}
