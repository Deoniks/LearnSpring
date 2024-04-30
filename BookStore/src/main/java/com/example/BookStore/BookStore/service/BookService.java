package com.example.BookStore.BookStore.service;

import com.example.BookStore.BookStore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookService {
    List<Book>getAll();
    void save(Book book);
    void delete(Book book);
    void deleteById(Long id);
    void updateById(Long id,Book book);
    Book getById(Long id);
}
