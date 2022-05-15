package com.example.flitapp.mvvm.models;

import java.util.Date;

public class User {
    private int id;
    private String firstName;
    private String secondName;
    private Date dateOfCreation;
    private int tasksDone;
    private int tasksCreated;
    private double rating;
    private TagsCount tagsCount;

    public User(int id) {
        this.id = id;
        this.firstName = "N/A";
        this.secondName = "N/A";
        this.dateOfCreation = new Date();
        this.tasksDone = 0;
        this.tasksCreated = 0;

        this.rating = 5;
        this.tagsCount = new TagsCount();
    }

    public User(int id, String firstName, String secondName, Date dateOfCreation, int tasksDone, int tasksCreated) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfCreation = dateOfCreation;
        this.tasksDone = tasksDone;
        this.tasksCreated = tasksCreated;

        this.rating = 5;
        this.tagsCount = new TagsCount();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setTasksDone(int tasksDone) {
        this.tasksDone = tasksDone;
    }

    public void setTasksCreated(int tasksCreated) {
        this.tasksCreated = tasksCreated;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public int getTasksDone() {
        return tasksDone;
    }

    public int getTasksCreated() {
        return tasksCreated;
    }

    public double getRating() {
        return rating;
    }
}
