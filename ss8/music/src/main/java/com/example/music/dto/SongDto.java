package com.example.music.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotEmpty(message = "không được để trống")
    @Size(max = 800 ,message = "kí tự không vượt quá 800")
    @Pattern(regexp = "^([\\p{L}\\s])+$",message = "không được chứa kí tự đặt biệt")
    private String name;
    @NotEmpty(message = "không được để trống")
    @Size(max = 300 ,message = "kí tự không vượt quá 300")
    @Pattern(regexp = "^([\\p{L}\\s])+$",message = "không được chứa kí tự đặt biệt")
    private String author;

    @NotEmpty(message = "không được để trống")
    @Size(max = 1000 ,message = "kí tự không vượt quá 1000")
    @Pattern(regexp = "^([\\p{L}\\s])+$",message = "không được chứa kí tự đặt biệt")
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String name, String author, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
