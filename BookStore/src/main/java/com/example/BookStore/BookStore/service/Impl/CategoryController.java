package com.example.BookStore.BookStore.service.Impl;

import com.example.BookStore.BookStore.domain.Category;
import com.example.BookStore.BookStore.repository.CategoryRepository;
import com.example.BookStore.BookStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class CategoryController implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    @GetMapping("/category/findAll")
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    @PostMapping("/category/save")
    public void save(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @Override
    @DeleteMapping("/category/delete")
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    @DeleteMapping("category/deleteBy/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @GetMapping("/category/findBy/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
