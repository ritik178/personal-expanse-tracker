package net.javaguides.expansetrackerapp.repository;

import net.javaguides.expansetrackerapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
