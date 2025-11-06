package com.team200.moviecatalog.repository.role;

import com.team200.moviecatalog.model.Role;
import com.team200.moviecatalog.model.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
