package com.board.toy.domain.category.dto;

import com.board.toy.domain.category.Category;
import lombok.Getter;

@Getter
public class SimpleCategoryDto {
    private Long id;

    private String name;

    private Boolean del;

    public SimpleCategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.del = category.getDel();
    }
}
