package com.company.chatterbook.models;

public class ChatterPost {
    // ChatterPost should have one string instance variable named text
    private String text;

    // Getters and setters just in case
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // We need a new constructor
    public ChatterPost(String text) {
        this.text = text;
    }
}
