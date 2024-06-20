package com.developerInternship.TaskFour;


public class Student {
	
	//been class invoked with id name age grade address
	private Long id ;
	private  String name;
	private  int age;
	private  String grade;
	private  String address;
	
	public Student() {}
	 // data refer to the parent class
	 public Student(Long id, String name, int age, String grade, String address) {
	        this.setId(id);
	        this.setName(name);
	        this.setAge(age);
	        this.setGrade(grade);
	        this.setAddress(address);
	    }
     //returning id 
	public long getId() {
		return id;
	}
    //setting id  
	public void setId(Long id) {
		this.id = id;
	}
    //returning name
	public String getName() {
		return name;
	}
    //setting name
	public void setName(String name) {
		this.name = name;
	}
    //returning age
	public int getAge() {
		return age;
	}
    //setting age
	public void setAge(int age) {
		this.age = age;
	}
    //returning grade
	public String getGrade() {
		return grade;
	}
    //setting grade
	public void setGrade(String grade) {
		this.grade = grade;
	}
    //returning address
	public String getAddress() {
		return address;
	}
    //setting address
	public void setAddress(String address) {
		this.address = address;
	}
	
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
	     
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Student student = (Student) o;
	        if (age != student.age) return false;	        
	        if (id != 0 ? id != student.id : student.id != 0) return false;
	        
	        if (name != null ? !name.equals(student.name) : student.name != null) return false;
	        if (grade != null ? !grade.equals(student.grade) : student.grade != null) return false;
	        return address != null ? address.equals(student.address) : student.address == null;

	    }
	     // return sort with id in hash map hash tree
	    @Override
	    public int hashCode() {
	    	int result = (id != null ? id.hashCode() : null);
	        result = 31 * result + (name != null ? name.hashCode() : 0);
	        result = 31 * result + age;
	        result = 31 * result + (grade != null ? grade.hashCode() : 0);
	        result = 31 * result + (address != null ? address.hashCode() : 0);
	        return result;	    }
}


