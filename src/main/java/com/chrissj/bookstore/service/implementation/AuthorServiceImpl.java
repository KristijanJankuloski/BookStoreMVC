package com.chrissj.bookstore.service.implementation;

import com.chrissj.bookstore.model.Author;
import com.chrissj.bookstore.model.exception.NoAuthorFoundException;
import com.chrissj.bookstore.repository.AuthorRepository;
import com.chrissj.bookstore.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author add(String name) {
        return authorRepository.save(new Author(name.trim()));
    }

    @Override
    public Author getById(int id) throws IOException {
        return authorRepository.findById(id).orElseThrow(() -> new NoAuthorFoundException(id));
    }

    @Override
    public void deleteById(int id) throws IOException {
        Author aDelete = getById(id);
        authorRepository.delete(aDelete);
    }

    @Override
    public Author update(int id, Author author) throws IOException {
        Author aUpate = getById(id);
        aUpate.setFullName(author.getFullName());
        return authorRepository.save(aUpate);
    }

    @Override
    public Author update(int id, String name) throws IOException {
        Author aUpdate = getById(id);
        aUpdate.setFullName(name.trim());
        return authorRepository.save(aUpdate);
    }
}
