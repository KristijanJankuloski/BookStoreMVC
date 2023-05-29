package com.chrissj.bookstore.service;

import com.chrissj.bookstore.model.Category;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAll();
    Category getById(int id) throws IOException;
    Category add(Category category);
    void deleteById(int id) throws  IOException;
    Category update(int id, Category category) throws IOException;
}
