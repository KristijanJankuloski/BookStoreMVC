package com.chrissj.bookstore.service;

import com.chrissj.bookstore.model.Author;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface AuthorService {
    List<Author> getAll();
    Author add(String name);
    Author getById(int id) throws IOException;
    void deleteById(int id) throws IOException;
    Author update(int id, Author author) throws IOException;
    Author update(int id, String name) throws IOException;
}
