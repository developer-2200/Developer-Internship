package InternshipTask.TaskThree;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int age;
    private String grade;
    private String address;
     
    //with constructor fetching data of student to private variables
    public Student(int id, String name, int age, String grade, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.address = address;
    }
    
    //returning id 
    public int getId() {
        return id;
    }
    
    //set id to private
    public void setId(int id) {
        this.id = id;
    }
    //return name of student
    public String getName() {
        return name;
    }
     //set student name to private
    public void setName(String name) {
        this.name = name;
    }
    //return age of student
    public int getAge() {
        return age;
    }
    //set age to private
    public void setAge(int age) {
        this.age = age;
    }
    //return grade of student
    public String getGrade() {
        return grade;
    }
    // set grade of student to private
    public void setGrade(String grade) {
        this.grade = grade;
    }
    //return address 
    public String getAddress() {
        return address;
    }
    //set student address to private
    public void setAddress(String address) {
        this.address = address;
    }
     //return id name age grade address to Student management to student set TreeSet<student>
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
     //if student exist in class return true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }
     // return sort with id in hash map hash tree
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
