package com.library.Models;
import com.library.DataBase.*;
public class Student extends User {
    public Student(String name, String userId, String userEmail, String password) {
        super(name, userId, userEmail, password);
    }

    public void borrowBook(DataBase db, Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println("Book returned: " + book.getTitle());
    }
}