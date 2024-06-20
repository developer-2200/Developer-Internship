package com.developerInternship.TaskFour;

import java.util.List;
import java.util.Scanner;

public class StudentsApp {
	//calling the scanner class
    private static Scanner scanner = new Scanner(System.in);
    //upcasting the StudentDAOImpl
    private static StudentService studentService = new StudentService(new StudentDAOImpl());

    public static void main(String[] args) {
        while (true) {
        	//implement CRUD operation 
            System.out.println("1. Add a new student");
            System.out.println("2. View all students");
            System.out.println("3. View a student by ID");
            System.out.println("4. Update a student");
            System.out.println("5. Delete a student");
            System.out.println("6. Exit");
             //asking for the above given option
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            //giving the choices with switch case statements
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    viewStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
    //method to adding the student
    private static void addStudent() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter grade: ");
        String grade = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        Student student = new Student(null, name, age, grade, address);
        studentService.addStudent(student);
        System.out.println("Student added successfully!");
    }
    //method to viewing all student list
    private static void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    //view student with id
    private static void viewStudentById() {
        System.out.println("Enter student ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Student student = studentService.getStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }
     //updating the students data
    private static void updateStudent() {
        System.out.println("Enter student ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter new grade: ");
        String grade = scanner.nextLine();
        System.out.println("Enter new address: ");
        String address = scanner.nextLine();

        Student updatedStudent = new Student(id, name, age, grade, address);
        studentService.updateStudent(updatedStudent);
        System.out.println("Student updated successfully!");
    }
    //deleting student account from database
    private static void deleteStudent() {
        System.out.println("Enter student ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully!");
    }
}
