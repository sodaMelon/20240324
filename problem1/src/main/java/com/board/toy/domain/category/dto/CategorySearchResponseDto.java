package com.board.toy.domain.category.dto;

import com.board.toy.domain.category.Category;
import lombok.Getter;

import java.util.List;

@Getter
public class CategorySearchResponseDto {
    private SimpleCategoryDto parentIdx;
    private SimpleCategoryDto currentCategory;
    private List<CategorySearchDto> child;

    public CategorySearchResponseDto(Category target, List<CategorySearchDto> child) {
        this.parentIdx = new SimpleCategoryDto(target.getParent());
        this.currentCategory = new SimpleCategoryDto(target);
        this.child = child;
    }
}


