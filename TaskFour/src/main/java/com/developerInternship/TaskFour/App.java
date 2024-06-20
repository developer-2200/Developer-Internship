package com.developerInternship.TaskFour;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        try {
            String db_url = "jdbc:mysql://localhost:3306/Student?serverTimezone=UTC";
            String user = "root";
            String password = "root";

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection con = DriverManager.getConnection(db_url, user, password);

            // Create a statement
            Statement st = con.createStatement();

            // Execute a query
            ResultSet rs = st.executeQuery("select * from student");

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                //String grade = rs.getString("grade");
                String address = rs.getString("address");

                // Print the result
                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("age: " + age);
                //System.out.println("grade: " + grade);
                System.out.println("address: " + address);
            }

            // Close the result set, statement, and connection
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
