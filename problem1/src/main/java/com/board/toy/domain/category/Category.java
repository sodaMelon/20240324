package com.board.toy.domain.category;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean del;

    @ManyToOne(fetch = FetchType.LAZY) //단방향 자가 참조
    @JoinColumn(name = "parent_id")
    private Category parent;
}
