package InternshipTask.TaskThree;

import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students;
    private HashMap<Integer, Student> studentMap;
    private TreeSet<Student> studentSet;
     // set the set map student to private
    public StudentManager() {
        students = new ArrayList<>();
        studentMap = new HashMap<>();
        studentSet = new TreeSet<>(Comparator.comparing(Student::getName));
    }
    //adding student with student amp if it all ready exist message display
    public void addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            System.out.println("Student with this ID already exists.");
            return;
        }
        students.add(student);
        studentMap.put(student.getId(), student);
        studentSet.add(student);
    }
    //with id removing student if all ready not exist else removed 
    public void removeStudent(int id) {
        Student student = studentMap.remove(id);
        if (student != null) {
            students.remove(student);
            studentSet.remove(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with this ID does not exist.");
        }
    }
    //with set updating the students data except id , id is to get the student data
    public void updateStudent(int id, String name, int age, String grade, String address) {
        Student student = studentMap.get(id);
        if (student != null) {
            studentSet.remove(student);
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            student.setAddress(address);
            studentSet.add(student);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with this ID does not exist.");
        }
    }
    //to search student use get id
    public Student searchStudent(int id) {
        return studentMap.get(id);
    }
    //printing the student detail calling toString to print
    public void displayAllStudents() {
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
   //for file to create and load the file 
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>)ois.readObject();
            studentMap.clear();
            studentSet.clear(); 
            for (Student student : students) {
                studentMap.put(student.getId(), student);
                studentSet.add(student);
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {//error if file not found  
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }
    //to save data to file with file name 
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }
}
