package com.example.BookStore.BookStore.repository;

import com.example.BookStore.BookStore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book,Long> {
}
