package com.board.toy.domain.board;

import com.board.toy.domain.category.Category;
import jakarta.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String memo;
    @OneToOne(fetch = FetchType.LAZY)
    private Category category;
}
