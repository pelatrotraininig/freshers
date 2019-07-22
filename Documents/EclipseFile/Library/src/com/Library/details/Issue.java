package com.Library.details;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Entity
public class Issue implements Serializable {
	@Id
	@GeneratedValue 
	private int IssueId;
	@OneToOne
	@JoinColumn(name="BookId")
	private BookDetails BookId;
	@OneToOne
	@JoinColumn(name="Student_Id")
	private StudentDetails Student_Id;
	@Basic
	private Date issueDate;
	private Date SubmissionDate;
	private float fine;
	private Date due_for_return;
	
	public Date getDue_for_return() {
		return due_for_return;
	}

	public void setDue_for_return(Date due_for_return) {
		this.due_for_return = due_for_return;
	}

	public float getFine() { 
		return fine;
	}

	public void setFine(float fine) {
		this.fine = fine;
	}

	public int getIssueId() {
		return IssueId;
	}

	public void setIssueId(int issueId) {
		IssueId = issueId;
	}
	
	public BookDetails getBookId() {
		return BookId;
	}

	public void setBookId(BookDetails bookId) {
		BookId = bookId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getSubmissionDate() {
		return SubmissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		SubmissionDate = submissionDate;
	}

	public StudentDetails getStudent_Id() {
		return Student_Id;
	}

	public void setStudent_Id(StudentDetails student_Id) {
		Student_Id = student_Id;
	}
	
	
//	private int StudentId;
//	private int count;

	
}
