package com.bongani.crud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bongani.model.Student;
import com.bongani.util.SessinUtil;

public class DatabaseOperation {

	Session session = null;
	Transaction transaction = null;
	int count = 0;
	Scanner sc = new Scanner(System.in);

	public DatabaseOperation() {
		session = SessinUtil.getSessionFactory().openSession();
	}

	public void insetStudent(Student student) {
		try {
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
			display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateStudent(int id) {
		List<Student> list = session.createQuery("FROM Student s").list();

		list.forEach(s -> {
			if (s.getId() == id) {
				Student std = list.get(count);
				System.out.println("write you marks");
				std.setMarks(sc.nextInt());
				transaction = session.beginTransaction();
				session.persist(std);
				transaction.commit();
				System.out.println("Your record is updated");
				display();
			} else {
				System.out.println("No data found!!!");
			}
			count++;
		});
		count = 0;

	}

	public void deleteStudent(int id) {
		List<Student> list = session.createQuery("FROM Student s").list();

		list.forEach(s -> {
			if (s.getId() == id) {
				Student std = list.get(count);
				transaction = session.beginTransaction();
				session.remove(std);
				transaction.commit();
				System.out.println("Your record is Deleted");
				display();
			} else {
				System.out.println("No data found!!!");
			}
			count++;
		});
		count = 0;
	}

	public void display() {
		System.out.println("All Students");
		List<Student> list = session.createQuery("FROM Student s").list();
		list.forEach(s -> System.out.println(s));
	}
}
