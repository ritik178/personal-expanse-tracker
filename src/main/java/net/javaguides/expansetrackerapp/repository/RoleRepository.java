package net.javaguides.expansetrackerapp.repository;

import net.javaguides.expansetrackerapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
       Role findByName(String name);
}
