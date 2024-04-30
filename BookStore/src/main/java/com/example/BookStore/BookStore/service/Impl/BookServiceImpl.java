package com.example.BookStore.BookStore.service.Impl;

import com.example.BookStore.BookStore.domain.Book;
import com.example.BookStore.BookStore.repository.BookRepository;
import com.example.BookStore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id,Book book) {
        if (!bookRepository.findById(id).isEmpty()){
            bookRepository.save(book);
        }
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
