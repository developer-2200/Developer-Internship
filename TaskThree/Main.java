package InternshipTask.TaskThree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        String filename = "student.txt";

        // Load data from file at startup
        manager.loadFromFile(filename);
        
        // Option in switch case for creating updating reading and removing student data
        while (true) {
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student by ID");
            System.out.println("3. Update student details by ID");
            System.out.println("4. Search for a student by ID");
            System.out.println("5. Display all students");
            System.out.println("6. Exit and save data");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
           // switch case statement for CRUD operation
            switch (choice) {
                case 1:// Adding student 
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    Student student = new Student(id, name, age, grade, address);
                    manager.addStudent(student);
                    break;
                case 2://Removing student with id
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    manager.removeStudent(id);
                    break;
                case 3:// updating student searching with id
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new grade: ");
                    grade = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    address = scanner.nextLine();
                    manager.updateStudent(id, name, age, grade, address);
                    break;
                case 4:// Searching for student by id name
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    student = manager.searchStudent(id);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student with this ID does not exist.");
                    }
                    break;
                case 5://Display students
                    manager.displayAllStudents();
                    break;
                case 6://Exit and saving the file
                    manager.saveToFile(filename);
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
