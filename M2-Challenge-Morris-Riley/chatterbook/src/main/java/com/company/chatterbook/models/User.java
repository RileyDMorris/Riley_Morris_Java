package com.company.chatterbook.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    // The User model object should contain the following two instance variables
    private String name;
    private List<ChatterPost> chatterPosts = new ArrayList<>();

    // It is also important to create a constructor that takes a string for name. This constructor will be used to setup the sample data in the controller class to create new Users.
    public User(String name) {
        this.name = name;
    }

    // We need to be able to set chatter posts
    public void setChatterPosts(List<ChatterPost> newPosts) {
        this.chatterPosts = newPosts;
    }

    // Need a getter for ChatterPosts
    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    // We need a name getter
    public String getName() {
        return name;
    }
}
