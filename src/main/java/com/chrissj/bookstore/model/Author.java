package com.chrissj.bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;

    public Author(String fullName) {
        this.fullName = fullName;
    }
    public Author(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public String getNameCapitalized(){
        var nameSplit= fullName.split(" ");
        var displayName = new StringBuilder();
        for (var word:nameSplit) {
            if(!word.isEmpty()){
               char firstLetter = Character.toUpperCase(word.charAt(0));
               String capitalizedWord = firstLetter + word.substring(1);
               displayName.append(capitalizedWord).append(" ");
            }
        }
        return displayName.toString().trim();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
