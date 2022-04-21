package com.example.flitapp.mvvm.models;

public class Task {
    private String header;
    private String price;
    private String[] tags;
    private String description;

    public Task(String header, String price, String[] tags, String description) {
        this.header = header;
        this.price = price;
        this.tags = tags;
        this.description = description;
    }

    public String getHeader() {
        return header;
    }

    public String getPrice() {
        return price;
    }

    public String[] getTags() {
        return tags;
    }

    public String getDescription() {
        return description;
    }
}
