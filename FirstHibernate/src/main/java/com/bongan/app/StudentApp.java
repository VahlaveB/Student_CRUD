package com.bongan.app;

import java.util.Scanner;

import com.bongani.crud.DatabaseOperation;
import com.bongani.model.Student;

public class StudentApp {

	public static void main(String[] args) {

		DatabaseOperation data = new DatabaseOperation();
		boolean isDone = true;
		Scanner sc = new Scanner(System.in);
		while (isDone) {
			System.out.println("Welcome To Student Console App");
			System.out.println("___________________________________________________");
			System.out.println("Choose Options:");
			System.out.println("########################################################");
			System.out.println(
					"1. Create Student: \n2. View All Students:\n3. Update Student Marks:\n4. Delete Student\n5.Stop Application");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				Student st = new Student();
				System.out.println("Enter name");
				st.setName(sc.next());
				System.out.println("Enter surname");
				st.setSurname(sc.next());
				System.out.println("Enter Age");
				st.setAge(sc.nextInt());
				System.out.println("Enter Marks");
				st.setMarks(sc.nextInt());
				data.insetStudent(st);
				break;
			case 2:
				data.display();
				break;
			case 3:
				System.out.println("enter an  id of student you wish to update  ");
				int id = sc.nextInt();
				data.updateStudent(id);
				break;
			case 4:
				System.out.println("enter an  id of student you wish to delete ");
				int id1 = sc.nextInt();
				data.deleteStudent(id1);
				break;
			case 5:
				isDone = false;
				break;
			default:
				System.out.println("No such Option Here");
			}
			System.out.println("___________________________________________________");
		}

	}

}
