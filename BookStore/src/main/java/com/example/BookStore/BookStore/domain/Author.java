package com.example.BookStore.BookStore.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AUTHOR")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;

    public Author(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }
}
