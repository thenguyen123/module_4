package com.example.book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<OderBook> oderBooks;


    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String name, int quantity, Set<OderBook> oderBooks) {
        this.id = id;
        this.name = name;

        this.quantity = quantity;
        this.oderBooks = oderBooks;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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


    public Set<OderBook> getBookSet() {
        return oderBooks;
    }

    public void setBookSet(Set<OderBook> oderBooks) {
        this.oderBooks = oderBooks;
    }
}
