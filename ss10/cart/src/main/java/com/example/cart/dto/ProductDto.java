package com.example.cart.dto;

public class ProductDto {
    private int id;
    private String name;
    private double prices;
    private String description;
    private String image;

    public ProductDto() {
    }

    public ProductDto(int id, String name, double prices, String description, String image) {
        this.id = id;
        this.name = name;
        this.prices = prices;
        this.description = description;
        this.image = image;
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

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
