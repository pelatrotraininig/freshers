package com.Library.file;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.Library.details.*;


public class HibernateTest {
	public static void main(String [] args) throws ParseException {
		StudentDetails sd = new StudentDetails();
		//sd.setStudentId(1);
		sd.setStudentName("Shubham Singh");
		sd.setAddress("Kalyan Nagar");
		sd.setEmail("shubham@gmail.com");
		
		StudentDetails sd2= new StudentDetails();
		//sd2.setStudentId(2);
		sd2.setStudentName("Ankit");
		sd2.setAddress("Electronic city");
		sd2.setEmail("ankit@gmail.com");
		
		StudentDetails sd3  = new StudentDetails();
		sd3.setStudentName("Anurag");
		sd3.setAddress("Kormangala");
		sd3.setEmail("Anurag@gmail.com");
		
		StudentDetails sd4 = new StudentDetails();
		sd4.setStudentName("Abhishek");
		sd4.setAddress("Electronic city");
		sd4.setEmail("abhishek@gmail.com");
		
		StudentDetails sd5 = new StudentDetails();
		sd5.setStudentName("Sumit");
		sd5.setAddress("IndraNagar");
		sd5.setEmail("sumit@gmail.com");
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	
	
	/*---------------------------BooksDetails Table adding value----------------------------------------- */
	
	BookDetails bd = new BookDetails();
	//bd.setIsbn("978-3-16-148410-0");
	bd.setBookId(1000);
	bd.setAuthorName("cormen");
	bd.setBookName("Alcom.Library.details.StudentDetailsgorithm and Data Structure");
	bd.setCount(6);
	
	
	//Second row
	BookDetails bd2 = new BookDetails();
//	bd2.setIsbn("978-3-16-148410-8");
	bd2.setBookId(1001);
	bd2.setAuthorName("Karumanchi");
	bd2.setBookName("Algorithms");
	bd.setCount(7);
	
	BookDetails bd3 = new BookDetails();
	//bd3.setIsbn("978-3-16-152340-0");
	bd3.setBookId(1003);
	bd3.setBookName("Operating System");
	bd3.setAuthorName("Galvin");
	bd3.setCount(8);
	
	BookDetails bd4 = new BookDetails();
//	bd4.setIsbn("778-3-16-148410-0");
	bd4.setBookId(1004);
	bd4.setAuthorName("Yashwant");
	bd4.setBookName("Let Us C");;
	bd4.setCount(12);
	
	BookDetails bd5 = new BookDetails();
	//bd5.setIsbn("978-3-13-148410-0");
	bd5.setBookId(1005);
	bd5.setAuthorName("Fourzan");
	bd5.setBookName("Computer Network");
	bd5.setCount(9);
	
	/*--------------------------------------------------Issue Table-----------------------------------------*/
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	Calendar c = Calendar.getInstance();
	java.util.Date d = format.parse("29/05/2019");
	
	Issue us = new Issue();
	java.util.Date IssueDate1 = format.parse("20/01/2019");
	java.util.Date SubDate1 =   format.parse("30/01/2019");
	c.setTime(IssueDate1);
	c.add(Calendar.DATE, 7);
	
	//java.util.Date ddr1 = format.parse("28/01/2019");

	String output=format.format(c.getTime());
	java.util.Date DueReturn1=format.parse(output);
	
	long date_diff = Math.abs((SubDate1.getTime()-DueReturn1.getTime()));
	float fine1 = date_diff/(1000*60*60*24);
	
	us.setIssueDate(IssueDate1);
	us.setSubmissionDate(SubDate1);
	us.setBookId(bd);
	us.setStudent_Id(sd);
	us.setDue_for_return(c.getTime());
	us.setFine(fine1);
	
	java.util.Date IssueDate2 = format.parse("12/06/2019");
	java.util.Date SubDate2 =   format.parse("28/07/2019");
	
	
	c.setTime(IssueDate2);
	c.add(Calendar.DATE, 28);
	String output2=format.format(c.getTime());
	java.util.Date ddr2=format.parse(output2);
	//java.util.Date ddr2 = format.parse("20/06/2019");
	
	long date_diff2 = Math.abs((SubDate2.getTime()-ddr2.getTime()));
	float fine2=date_diff2/(1000*60*60*24);
	
	Issue us2 = new Issue();
	us2.setIssueDate(IssueDate2);
	us2.setSubmissionDate(SubDate2);
	us2.setBookId(bd2);
	us2.setStudent_Id(sd2);
	us2.setDue_for_return(ddr2);
	us2.setFine(fine2);
	
	java.util.Date IssueDate3 = format.parse("10/05/2019");
	java.util.Date subDate3 = format.parse("20/05/2019");
	long date_diff3=Math.abs(subDate3.getTime()-IssueDate3.getTime());
	float fine3=date_diff3/(1000*60*60*24);
	c.setTime(IssueDate3);
	c.add(Calendar.DATE, 7);
	String ddr3 = format.format(c.getTime());
	Issue us3 = new Issue();
	us3.setBookId(bd3);
	us3.setIssueDate(IssueDate3);
	us3.setStudent_Id(sd);
	us3.setDue_for_return(c.getTime());
	us3.setSubmissionDate(subDate3);
	us3.setFine(fine3-7);
	
	Issue us4 = new Issue();
	us4.setBookId(bd4);
	us4.setStudent_Id(sd4);

	/*--------------------------------Session save--------------------------------------------------*/
	session.save(sd);
	session.save(sd2);
	session.save(sd3);
	session.save(sd4);
	session.save(sd5);
	session.save(bd);
	session.save(bd2);
	session.save(bd3);
	session.save(bd3);
	session.save(bd4);
	session.save(bd5);
	session.save(us);
	session.save(us2);
	session.save(us3);
	session.save(us4);
	
	String hql ="from StudentDetails";
	Query query= session.createQuery(hql);
	List<StudentDetails> user = (List<StudentDetails>)query.list();
	
	Query query2 = session.createQuery("from BookDetails");
	//List<BookDetails> book = (List<BookDetails>)query.list();
	
	Query query3 = session.createQuery("select b.BookName from BookDetails b,Issue u where b.BookId=u.BookId");
	List result = query3.list();
	
	
	Query query4 = session.createQuery("select b.AuthorName from BookDetails b,Issue u where b.BookId=u.BookId");
	List result4 = query4.list();
	
	Query query5 = session.createQuery("select u.BookId from Issue u where u.Student_Id=1");
	List<BookDetails> result5 = (List<BookDetails>)query5.list();
	
	Query query6 =session.createQuery("select distinct s.StudentName from StudentDetails s,Issue u  where s.StudentId=u.Student_Id");
	List result6 = query6.list();
	
	//int x=1;
	Query query7=session.createQuery("select count(*) from Issue where Student_Id=1");
	//Query query7=session.createQuery("select count(*) from Issue where Student_Id = :value").setParameter("value",1);
	List<Issue> result7= (List<Issue>)query7.list();
	
	Query query8 =session.createQuery("select s  from StudentDetails s where s.StudentId not in ( select i.Student_Id from Issue i)");
	List<StudentDetails> result8 =(List<StudentDetails>) query8.list();
	
	
	Query query9=session.createQuery("select distinct s.Email from StudentDetails s,Issue u where s.StudentId=u.Student_Id");
	List result9=query9.list();
//	
//	Query query9=session.createQuery("from Issue where issueDate>=:ID1").setParameter("ID1",d );
//	List<Issue> result9=(List<Issue>)query9.list();
	
	session.getTransaction().commit();
	session.close();
	
//	for(StudentDetails q : user) {
//		System.out.println("Student Name - "+q.getStudentName());
//		System.out.println("Author Name - "+q.getStudentId());System.ouSystem.out.println("Student who have issued the book "+result6);t.println("Student who have issued the book "+result6);
//	//	System.out.println("Book Name - "+ q.getBookName());
//	}
	
//	for(BookDetails b : book) {
//		System.out.println("Book Id - "+b.getBookId());
//		System.out.println("Author Name - "+b.getAuthorName());
//		System.out.println("Book Name - "+b.getBookName());
//		System.out.println("Book Count - "+b.getBookCount());
//		
//	//	System.out.println("Book Name - "+ q.getBookName());
//	}
	//System.out.println("  "+result.get(0).toString()+"\n"+result.get(1).toString());
//	System.out.println(query3.list());
	//System.out.println("  "+result4.get(0).toString()+"\n"+result4.get(1).toString());
//	
	System.out.println("Book Id issued from student id 1 ");
	for(BookDetails u : result5) {
		System.out.println("Book Id "+u.getBookId());
	}
	System.out.println("Student who have issued the book\n Name");
	for(int i=0;i<result6.size();i++) {
		System.out.println(result6.get(i));
		//System.out.println("Student email id who have issued the book ");
	}
	//System.out.println("Student who have issued the book "+result6.get(0)+","+result6.get(1)+","+result6.get(2));
	System.out.println("Student email id who have issued the book\n"+result9.get(0)+","+result9.get(1)+","+result9.get(2));

	System.out.println(result7);
	
	for(StudentDetails s:result8) {
		System.out.println("Student who have not issued the book, Id and Name: "+s.getStudentId()+" "+s.getStudentName());
	}
	
//	for(Issue x:result7) {
//		System.out.println(x.getStudent_Id().getStudentId());
//	}
		
	
//	int status=IssueDate1.compareTo(IssueDate2);
//	if(status==0)
//		System.out.println("Same Date");
//	else if (status>0)
//		System.out.println("date1 is newer");
//	else 
//		System.out.println("Date1 is older");
	}
	
}
