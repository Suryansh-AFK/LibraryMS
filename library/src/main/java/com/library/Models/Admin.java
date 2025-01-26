package com.library.Models;
import com.library.DataBase.*;
public class Admin extends User {
    public Admin(String name, String userId, String userEmail, String password) {
        super(name, userId, userEmail, password);
    }

    public void addBook(DataBase db, Book book) {
        db.addBook(book);
        System.out.println("Book added: " + book.getTitle());
    }
}