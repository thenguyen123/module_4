package com.example.email.model;

public class Email {
    private int id;

    private String languages;
    private int size;
    private boolean spamsFilter;
    private String Signature;

    public Email() {
    }
    public Email(int id, String languages, int size, boolean spamsFilter, String signature) {
        this.id = id;
        this.languages = languages;
        this.size = size;
        this.spamsFilter = spamsFilter;
        Signature = signature;
    }
    public Email(String languages, int size, boolean spamsFilter, String signature) {
        this.languages = languages;
        this.size = size;
        this.spamsFilter = spamsFilter;
        Signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
