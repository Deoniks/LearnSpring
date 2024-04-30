package com.example.BookStore.BookStore.controller;

import com.example.BookStore.BookStore.domain.Author;
import com.example.BookStore.BookStore.domain.Book;
import com.example.BookStore.BookStore.domain.Category;
import com.example.BookStore.BookStore.repository.AuthorRepository;
import com.example.BookStore.BookStore.repository.BookRepository;
import com.example.BookStore.BookStore.repository.CategoryRepository;
import com.example.BookStore.BookStore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
@RestController
@RequestMapping("/book")
@Primary
public class BookController implements BookService {
    @Autowired
    private final BookRepository bookRepository;

    private Logger log = LoggerFactory.getLogger(BookController.class);


    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    @GetMapping("/findAll")
    public List<Book> getAll() {
        log.info("Find all book");
        return bookRepository.findAll();
    }

    @Override
    @PostMapping("/save")
    public void save(@RequestBody Book book) {
        Long idAuthor = book.getAuthor().getId();
        log.info("author:{}",idAuthor);
        bookRepository.save(book);
        log.info("Save book:{}",bookRepository.findById(book.getId()));

        //add to author and category...
        /*
        *save from json
        *      {
        "id":2,
        "title": "tdfsitle",
        "author": {
            "id": 2,
            "name": "Authsdaor A.R",
            "biography": "It's a gooddsfse autoBio"
        },
        "category": {
            "id": 2,
            "name": "dseegory",
            "description": "This is not category"
        },
        "isbn": "8574234213",
        "publichedDate": "3879-03-02T18:00:00.000+00:00",
        "price": 2500.0
    }
        * */
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(@RequestBody Book book) {
        log.info("Delete book",book);
        bookRepository.delete(book);
    }

    @Override
    @DeleteMapping("/deleteBy/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Delete book: {}",bookRepository.findById(id));
        bookRepository.deleteById(id);
    }

    @Override
    @GetMapping("/findBy/{id}")
    public Book getById(@PathVariable Long id) {
        log.info("find book: {}",bookRepository.findById(id));
        return bookRepository.findById(id).orElse(null);
    }
}
