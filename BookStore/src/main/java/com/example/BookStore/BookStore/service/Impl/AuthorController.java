package com.example.BookStore.BookStore.service.Impl;

import com.example.BookStore.BookStore.domain.Author;
import com.example.BookStore.BookStore.repository.AuthorRepository;
import com.example.BookStore.BookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class AuthorController implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @GetMapping("/author/findAll")
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    @PostMapping("/author/save")
    public void save(@RequestBody Author author) {
        authorRepository.save(author);
    }

    @Override
    @DeleteMapping("/author/delete")
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    @DeleteMapping("/author/deleteBy/{id}")
    public void deleteById(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    @GetMapping("/author/findBy/{id}")
    public Author getById(@PathVariable Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}
