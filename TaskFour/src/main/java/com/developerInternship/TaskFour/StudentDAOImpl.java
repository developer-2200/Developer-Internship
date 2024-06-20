package com.developerInternship.TaskFour;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;



public class StudentDAOImpl implements StudentDAO {
    private Connection connection;
	
          
       
        //getting connected with data base
        public StudentDAOImpl() {
        try {
        	//initialization of properties class for Driver Data Resource Management
        	 Properties prop = new Properties(); 
             InputStream ipStream = new FileInputStream(new File("src\\main\\resources\\db.properties"));
             
             prop.load(ipStream);
             
             String driverClassName =prop.getProperty("driver.class.name");
             String dbURL = prop.getProperty("db.url");
             String dbUserName = prop.getProperty("db.username");
             String dbPassword = prop.getProperty("db.password");
             
             Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     //overriding the addStudent to create student to database
    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO st_data (name, age, grade, address) VALUES (?, ?, ?, ?)";
        //using prepared statement because it contain pre -compiled SQL Query
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGrade());
            ps.setString(4, student.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Bring the data from data base
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM st_data";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("grade"),
                        rs.getString("address")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
      // with student id searching for student in data base
    @Override
    public Student getStudentById(Long id) {
        Student student = null;
        String query = "SELECT * FROM st_data WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    student = new Student(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("grade"),
                            rs.getString("address")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
     //updating the student data
    @Override
    public void updateStudent(Student student) {
        String query = "UPDATE st_data SET name = ?, age = ?, grade = ?, address = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGrade());
            ps.setString(4, student.getAddress());
            ps.setLong(5, student.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //deleting the student 
    @Override
    public void deleteStudent(Long id) {
        String query = "DELETE FROM st_data WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

