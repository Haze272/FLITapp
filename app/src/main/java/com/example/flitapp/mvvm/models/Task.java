package com.example.flitapp.mvvm.models;

import java.util.ArrayList;
import java.util.Date;

public class Task {
    private int id;
    private String header;
    private String price;
    private String[] tags;
    private String description;
    private Date dateOfCreation;

    public Task(int id, String header, String price, String[] tags, String description, Date dateOfCreation) {
        this.id = id;
        this.header = header;
        this.price = price;
        this.tags = tags;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
    }

    public int getId() {
        return id;
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

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
