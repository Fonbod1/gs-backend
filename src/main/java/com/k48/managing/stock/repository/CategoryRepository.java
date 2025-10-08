package com.k48.managing.stock.repository;
import java.util.Optional;

import com.k48.managing.stock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCode(String code);

}