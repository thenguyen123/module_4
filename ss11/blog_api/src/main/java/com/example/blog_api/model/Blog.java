package com.example.blog_api.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    @Column( columnDefinition="text")
    private String content;
    private String date;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id" )
    private Category category;

    public Blog(int id, String name, String author, String content, String date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public Blog(int id, String name, String author, String content, String date, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(String name, String author, String content, String date) {
        this.name = name;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

