package com.example.BookStore.BookStore.service;

import com.example.BookStore.BookStore.domain.Book;
import com.example.BookStore.BookStore.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    void save(Category category);
    void delete(Category category);
    void deleteById(Long id);
    Category getById(Long id);
}
