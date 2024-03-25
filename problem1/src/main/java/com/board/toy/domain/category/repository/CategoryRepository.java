package com.board.toy.domain.category.repository;

import com.board.toy.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom{
    Optional<Category> findOneByNameContains(String keyword);
}
