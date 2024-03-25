package com.board.toy.domain.category.dto;

import lombok.Getter;

@Getter
public class CategorySearchRequestDto {
    private Long categoryId;
    private String nameKeyword;
    //todo validation: 적어도 하나의 멤버 변수가 null이 아니도록 검증
}
