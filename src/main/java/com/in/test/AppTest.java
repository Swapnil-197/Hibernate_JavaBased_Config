package com.in.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.in.entity.Student;
import com.in.util.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getMySqlSession().openSession()){
			Transaction transaction = session.beginTransaction();
			Student student = new Student();
			student.setFirstName("pqr");
			student.setLastName("abc");
			student.setMarks(85);		
			session.persist(student);
			transaction.commit();
		}catch(Exception e) {
			System.out.println("Error while insertion");
			e.printStackTrace();
		}
	}
}
