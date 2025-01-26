package com.library;
import com.library.DataBase.*;

import com.library.Models.*;
import com.library.Service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Library Management System");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Add Book (Admin only)");
            System.out.println("4. Borrow Book (Student only)");
            System.out.println("5. Return Book (Student only)");
            System.out.println("6. Display Books");
            System.out.println("7. Download E book");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    management.registerUser ();
                    break;
                case 2:
                    management.loginUser ();
                    break;
                case 3:
                    management.addBook();
                    break;
                case 4:
                    // Assuming the user is already logged in as a Student
                    System.out.println("Enter your userId: ");
                    String studentId = scanner.nextLine();
                    Student student = management.getStudentById(studentId);
                    if (student != null) {
                        management.borrowBook(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    // Assuming the user is already logged in as a Student
                    System.out.println("Enter your userId: ");
                    String returnStudentId = scanner.nextLine();
                    Student returnStudent = management.getStudentById(returnStudentId);
                    if (returnStudent != null) {
                        management.returnBook(returnStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    management.displayBooks();
                    break;

                case 7:
                    management.downloadBooks();

                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}