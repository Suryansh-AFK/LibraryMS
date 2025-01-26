package com.library.Models;

public class Book {
    private String title;
    private String author;
    private boolean available;
    private String filePath;

    public Book(String title, String author, boolean available, String filePath) {
        this.title = title;
        this.author = author;
        this.available = available;
        this.filePath = filePath;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }


}