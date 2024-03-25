package com.board.toy.domain.category.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class CategorySearchDto {

    @JsonIgnore
    private Long categoryId;

    @JsonIgnore
    private String categoryName;

    @JsonIgnore
    private Boolean categoryIsDel;

    @JsonIgnore
    private Long categoryParentId;

    @JsonIgnore
    private Long mappingId;

    private Long boardId;

    private String boardName;

    private Boolean boardIsDel;

    private Boolean boardIsAnonymous;

    @QueryProjection

    public CategorySearchDto(Long categoryId, String categoryName, Boolean categoryIsDel, Long categoryParentId,
                             Long mappingId,
                             Long boardId, String boardName, Boolean boardIsDel, Boolean boardIsAnonymous) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryIsDel = categoryIsDel;
        this.categoryParentId = categoryParentId;
        this.mappingId = mappingId;
        this.boardId = boardId;
        this.boardName = boardName;
        this.boardIsDel = boardIsDel;
        this.boardIsAnonymous = boardIsAnonymous;
    }
}
