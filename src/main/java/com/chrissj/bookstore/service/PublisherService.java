package com.chrissj.bookstore.service;

import com.chrissj.bookstore.model.Author;
import com.chrissj.bookstore.model.Publisher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface PublisherService {
    List<Publisher> getAll();
    Publisher getById(int id) throws IOException;
    Publisher add(String name, String address);
    Publisher update(int id, Publisher publisher) throws IOException;
    void deleteById(int id) throws IOException;
}
