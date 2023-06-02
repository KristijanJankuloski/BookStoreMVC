package com.chrissj.bookstore.model;

import jakarta.persistence.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.lang.NonNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String imagePath;
    private String imageType;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

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

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
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

    public String getImage() throws IOException {
        if (this.imagePath.isEmpty()){
            return null;
        }
        File image = new File(this.imagePath);
        byte[] bytes = Files.readAllBytes(image.toPath());
        return String.format("data:%s;base64,%s", this.imageType, Base64.getEncoder().encodeToString(bytes));
    }
}
