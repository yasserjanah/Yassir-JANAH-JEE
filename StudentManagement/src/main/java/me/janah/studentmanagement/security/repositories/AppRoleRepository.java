package me.janah.studentmanagement.security.repositories;

import me.janah.studentmanagement.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String role);
}
