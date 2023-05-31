package com.chrissj.bookstore.service;

import com.chrissj.bookstore.model.Author;
import com.chrissj.bookstore.model.Category;
import com.chrissj.bookstore.model.Product;
import com.chrissj.bookstore.model.Publisher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {
    List<Product> getAll();
    Product getById(int id) throws IOException;
    Product add(Product product);
    Product add(String name, Float price, Category category, Publisher publisher, Author author);
    Product add(String name, Float price, Category category, Publisher publisher, Author author, MultipartFile image);
    void deleteById(int id) throws IOException;
    Product update(int id, Product product) throws IOException;
    Product updateImage(int id, MultipartFile image) throws IOException;
}
