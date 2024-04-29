package com.example.BookStore.BookStore.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    /*@OneToOne
    @JoinColumn(name = "author_id")*/
    private String author;
    /*@OneToOne
    @JoinColumn(name = "category_id")*/
    private String category;
    private String isbn;
    private Date publichedDate;
    private double price;

    public Book(String title, String author, String category, String isbn, Date publichedDate, double price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.publichedDate = publichedDate;
        this.price = price;
    }
}
