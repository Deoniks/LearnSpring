package com.example.BookStore.BookStore.starter;

import com.example.BookStore.BookStore.domain.Author;
import com.example.BookStore.BookStore.domain.Book;
import com.example.BookStore.BookStore.domain.Category;
import com.example.BookStore.BookStore.repository.CategoryRepository;
import com.example.BookStore.BookStore.service.AuthorService;
import com.example.BookStore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationStarter implements CommandLineRunner {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Author A.R","It's a good autoBio");
        Category category = new Category("Category","This is category");
        Book book = new Book("title",author,category,"8574234213",new Date(1979,02,03),2500);

        bookService.save(book);
        authorService.save(author);
        categoryRepository.save(category);
    }
}
