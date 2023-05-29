package com.chrissj.bookstore.service.implementation;

import com.chrissj.bookstore.model.Category;
import com.chrissj.bookstore.model.exception.NoCategoryFoundException;
import com.chrissj.bookstore.repository.CategoryRepository;
import com.chrissj.bookstore.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) throws IOException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoCategoryFoundException(id));
    }

    @Override
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) throws IOException {
        Category categoryToDelete = getById(id);
        categoryRepository.delete(categoryToDelete);
    }

    @Override
    public Category update(int id, Category category) throws IOException {
        Category categoryToUpdate = getById(id);
        categoryToUpdate.setName(category.getName());
        return categoryRepository.save(categoryToUpdate);
    }
}
