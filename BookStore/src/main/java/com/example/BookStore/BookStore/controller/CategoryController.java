package com.example.BookStore.BookStore.controller;

import com.example.BookStore.BookStore.domain.Category;
import com.example.BookStore.BookStore.repository.CategoryRepository;
import com.example.BookStore.BookStore.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Primary
public class CategoryController implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private Logger log = LoggerFactory.getLogger(CategoryRepository.class);

    @Override
    @GetMapping("/findAll")
    public List<Category> getAll() {
        log.info("find all: {}");
        return categoryRepository.findAll();
    }

    @Override
    @PostMapping("/save")
    public void save(@RequestBody Category category) {
        categoryRepository.save(category);
        log.info("Save category: {}",categoryRepository.findById(category.getId()));
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(@RequestBody Category category) {
        categoryRepository.delete(category);
    }

    @Override
    @DeleteMapping("/deleteBAY/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Delete:{}",categoryRepository.findById(id));
        categoryRepository.deleteById(id);
    }

    @Override
    @GetMapping("/findBy/{id}")
    public Category getById(@PathVariable Long id) {
        log.info("Find by: {}",categoryRepository.findById(id));
        return categoryRepository.findById(id).orElse(null);
    }
}
