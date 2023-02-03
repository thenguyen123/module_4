package com.example.products.model;

public class Products {
    private int id;
    private String name;
    private int prices;
    private String description;
    private String producer;

    public Products(int id, String name, int prices, String description, String producer) {
        this.id = id;
        this.name = name;
        this.prices = prices;
        this.description = description;
        this.producer = producer;
    }

    public Products() {
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

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
