package com.example.book.model;

import javax.persistence.*;

@Entity
public class OderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String IdCard;


    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public OderBook() {
    }

    public OderBook(String idCard, Book book) {
        IdCard = idCard;
        this.book = book;
    }

    public OderBook(int id, String idCard, Book book) {
        this.id = id;
        IdCard = idCard;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
