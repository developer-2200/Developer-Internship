package com.developerInternship.TaskFour;

import java.util.List;
//creating interface
public interface StudentDAO {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}