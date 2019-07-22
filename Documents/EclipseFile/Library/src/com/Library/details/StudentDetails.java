package com.Library.details;

import java.util.*;

import javax.persistence.*;

@Entity 
@Table(name="Student_Details")
public class StudentDetails {
	@Id
	@GeneratedValue
	private int StudentId;
	private String StudentName;
	private String Address;
	private String Email;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	
	
}
