package com.example.BookStore.BookStore.controller;

import com.example.BookStore.BookStore.domain.Author;
import com.example.BookStore.BookStore.repository.AuthorRepository;
import com.example.BookStore.BookStore.repository.BookRepository;
import com.example.BookStore.BookStore.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController{
    private Logger log = LoggerFactory.getLogger(AuthorController.class);
    @Autowired
    private final AuthorRepository authorRepository;


    @Autowired
    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @GetMapping("/findAll")
    public List<Author> getAll() {
        log.info("Author All: {}");
        return authorRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Author author) {
        authorRepository.save(author);
        log.info("Save: {}",authorRepository.findById(author.getId()));
    }

    @DeleteMapping("/delete")
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @DeleteMapping("/deleteBy/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Delete:",authorRepository.findById(id));
        authorRepository.deleteById(id);
    }

    @GetMapping("/findBy/{id}")
    public Author getById(@PathVariable Long id) {
        log.info("Find by: {}",authorRepository.findById(id));
        return authorRepository.findById(id).orElse(null);
    }
}
