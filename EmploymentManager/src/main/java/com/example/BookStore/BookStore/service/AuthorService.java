package com.example.BookStore.BookStore.service;

import com.example.BookStore.BookStore.domain.Author;
import com.example.BookStore.BookStore.domain.Book;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    void save(Author author);
    void delete(Author author);
    void deleteById(Long id);
    Author getById(Long id);
}
