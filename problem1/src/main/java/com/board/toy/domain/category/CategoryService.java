package com.board.toy.domain.category;

import com.board.toy.common.exceptions.NotFoundException;
import com.board.toy.domain.category.dto.CategorySearchDto;
import com.board.toy.domain.category.dto.CategorySearchRequestDto;
import com.board.toy.domain.category.dto.CategorySearchResponseDto;
import com.board.toy.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final int indexThatHasNoBoard = 0;
    public CategorySearchResponseDto search(CategorySearchRequestDto dto) {
        Long categoryId = dto.getCategoryId();
        Optional<Category> target;
        if (categoryId == null) {
            //todo 1 현재시점에선 키워드로 검색했을때, 하나만 받지만.. %키워드% 검색으로 결과가 여러개 나올 수도 있으므로  해당 부분 검토 필요
            //todo 2 지금 이대로 나가면 n+1 문제 발생하므로 dto로 가져오거나 fetch join으로 교체
            target = categoryRepository.findOneByNameContains(dto.getNameKeyword());
            }
        else{
            target = categoryRepository.findById(categoryId);
        }
        target.orElseThrow(NotFoundException::new);
        categoryId = target.get().getId();
        List<CategorySearchDto> result = categoryRepository.findSearchCategories(categoryId);
        result.remove(indexThatHasNoBoard);//todo 여러개의 카테고리를 다루게 될때, stream으로 그룹화 해서 결과값 다뤄야함
        return new CategorySearchResponseDto(target.get(),result);
    }
}
