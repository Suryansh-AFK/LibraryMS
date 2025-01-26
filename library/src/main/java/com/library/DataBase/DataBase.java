package com.library.DataBase;

import java.util.ArrayList;
import com.library.Models.*;

public class DataBase {
    private ArrayList<Admin> admins;
    private ArrayList<Student> students;
    private ArrayList<Book> books;

    public DataBase() {
        admins = new ArrayList<>();
        students = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void addUser (User user) {
        if (user instanceof Admin) {
            admins.add((Admin) user);
        } else if (user instanceof Student) {
            students.add((Student) user);
        } else {
            System.out.println("User  should be an instance of User class!");
            return;
        }
        System.out.println("User  successfully added: " + user.getUserId());
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}