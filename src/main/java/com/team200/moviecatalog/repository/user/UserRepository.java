package com.team200.moviecatalog.repository.user;

import com.team200.moviecatalog.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByNickname(String username);

    @EntityGraph(attributePaths = "roles")
    Optional<User> findByEmail(String email);
}
