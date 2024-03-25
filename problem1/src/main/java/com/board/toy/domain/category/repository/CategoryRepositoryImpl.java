package com.board.toy.domain.category.repository;



import com.board.toy.domain.category.dto.CategorySearchDto;
import com.board.toy.domain.category.dto.QCategorySearchDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.board.toy.domain.board.QBoard.board;
import static com.board.toy.domain.category.QCategory.category;
import static com.board.toy.domain.categoryboardmapping.QCategoryBoardMapping.categoryBoardMapping;

@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepositoryCustom{
    private  final JPAQueryFactory queryFactory;

    @Override
    public List<CategorySearchDto> findSearchCategories(Long categoryId){
        return queryFactory.select(new QCategorySearchDto(category.id, category.name, category.del, category.parent.id,
                        categoryBoardMapping.id,
                        board.id, board.name, board.del, board.anonymous)).from(category)
                .leftJoin(categoryBoardMapping).on(categoryBoardMapping.categoryId.eq(category.id))
                .leftJoin(board).on(board.id.eq(categoryBoardMapping.boardId))
                .where(category.id.eq(categoryId).or(category.parent.id.eq(categoryId))).fetch();
    }
}
