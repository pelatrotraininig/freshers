package com.Library.details;

import java.util.Date;

import javax.persistence.*;
@Entity
public class BookDetails {
	@GeneratedValue
	@Id
	//private String Isbn;
	private int BookId;
	private String BookName;
	private String AuthorName;
	private int count;

	
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
//	public String getIsbn() {
//		return Isbn;
//	}
//	public void setIsbn(String isbn) {
//		Isbn = isbn;
//	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
