package com.board.toy.domain.category.repository;

import com.board.toy.domain.category.dto.CategorySearchDto;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<CategorySearchDto> findSearchCategories(Long categoryId);
}
