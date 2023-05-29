package com.chrissj.bookstore.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private int id;
    @NonNull
    private String name;
    @NonNull
    private Float price;
    @NonNull
    @ManyToOne
    private Category category;
    @NonNull
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors;

    public Product(@NonNull String name, @NonNull Float price, Category category, @NonNull Publisher publisher, List<Author> authors) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.publisher = publisher;
        this.authors = authors;
    }
    public Product(@NonNull String name, @NonNull Float price, @NonNull Category category, @NonNull Publisher publisher, Author author){
        this.name = name;
        this.price = price;
        this.category = category;
        this.publisher = publisher;
        this.authors = new ArrayList<Author>();
        authors.add(author);
    }
    public Product(){
        this.authors = new ArrayList<Author>();
    }

    @NonNull
    public Category getCategory() {
        return category;
    }

    public void setCategory(@NonNull Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Float getPrice() {
        return price;
    }

    public void setPrice(@NonNull Float price) {
        this.price = price;
    }

    @NonNull
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(@NonNull Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
