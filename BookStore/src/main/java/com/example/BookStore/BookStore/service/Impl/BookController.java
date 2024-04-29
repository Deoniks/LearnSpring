package com.example.BookStore.BookStore.service.Impl;

import com.example.BookStore.BookStore.domain.Book;
import com.example.BookStore.BookStore.repository.BookRepository;
import com.example.BookStore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class BookController implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    @GetMapping("/book/findAll")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    @PostMapping("/book/save")
    public void save(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @Override
    @DeleteMapping("/book/delete")
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    @DeleteMapping("/book/deleteBy/{id}")
    public void deleteById(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @GetMapping("/book/findBy/{id}")
    public Book getById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
