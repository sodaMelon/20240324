package com.board.toy.domain.category;

import com.board.toy.domain.category.dto.CategorySearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/search")
    public ResponseEntity search(@RequestBody CategorySearchRequestDto dto){
        return ResponseEntity.ok(categoryService.search(dto));
    }


}
