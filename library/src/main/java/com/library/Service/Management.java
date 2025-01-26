package com.library.Service;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
import com.library.DataBase.*;
import com.library.Models.*;

import java.util.Scanner;

import static org.apache.pdfbox.pdmodel.PDDocument.*;

public class Management {
    private DataBase dataBase;
    private Scanner scanner;

    public Management() {
        this.dataBase = new DataBase();
        this.scanner = new Scanner(System.in);
    }

    public void registerUser() {
        System.out.println("Enter user type (Admin/Student): ");
        String userType = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter userId: ");
        String userId = scanner.nextLine();
        System.out.println("Enter userEmail: ");
        String userEmail = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        if (userType.equalsIgnoreCase("Admin")) {
            Admin admin = new Admin(name, userId, userEmail, password);
            dataBase.addUser(admin);
        } else if (userType.equalsIgnoreCase("Student")) {
            Student student = new Student(name, userId, userEmail, password);
            dataBase.addUser(student);
        } else {
            System.out.println("Invalid user type.");
        }
    }

    public void loginUser() {
        System.out.println("Enter userId: ");
        String userId = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // Check for Admin
        for (Admin admin : dataBase.getAdmins()) {
            if (admin.getUserId().equals(userId) && admin.getPassword().equals(password)) {
                System.out.println("Admin logged in: " + admin.getUserId());
                return;
            }
        }

        // Check for Student
        for (Student student : dataBase.getStudents()) {
            if (student.getUserId().equals(userId) && student.getPassword().equals(password)) {
                System.out.println("Student logged in: " + student.getUserId());
                return;
            }
        }

        System.out.println("Invalid credentials.");
    }

    public void addBook() {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        System.out.println("Enter book author: ");
        String author = scanner.nextLine();
        System.out.println("Enter file path: ");
        String filePath = scanner.nextLine();
        Book book = new Book(title, author, true, filePath);
        dataBase.addBook(book);
    }

    public void borrowBook(Student student) {
        System.out.println("Enter book title to borrow: ");
        String title = scanner.nextLine();
        for (Book book : dataBase.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                student.borrowBook(dataBase,                book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(Student student) {
        System.out.println("Enter book title to return: ");
        String title = scanner.nextLine();
        for (Book book : dataBase.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                student.returnBook(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : dataBase.getBooks()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
        }
    }
    public Student getStudentById(String userId) {
      for (Student student : dataBase.getStudents()) {
          if (student.getUserId().equals(userId)) {
              return student;
          }
      }
      return null;
  }
public void downloadBooks() {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        try {
            PDDocument document = Loader.loadPDF(new File("C:\\Users\\bbtha\\OneDrive\\Desktop\\class\\New folder\\library\\src\\main\\java\\com\\library\\" + title + ".pdf"));

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println(text);
        }catch (IOException e) {
            System.err.println("An error occurred while processing the PDF document.");
            e.printStackTrace();
        }
}
}