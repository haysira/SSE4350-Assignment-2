package com.sse4350.view;


import java.util.ArrayList;
import java.util.Scanner;

import com.sse4350.model.Student;

public class StudentView {
	private int choice;
	
	public StudentView() {

	}
	
	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	Scanner input = new Scanner(System.in);

	public Student inputForm() {
		System.out.println();
		System.out.println("STUDENT FORM");
		System.out.print("ID Student: ");
		int id = input.nextInt();
		System.out.print("Name: ");
		String name = input.next();
		System.out.print("Department: ");
		String department = input.next();
		System.out.print("Math: ");
		double math = input.nextDouble();
		System.out.print("Science: ");
		double science = input.nextDouble();
		Student model = new Student(id, name, department, math, science);
		return model;
	}

	public int searchForm() {
		System.out.println();
		System.out.println("SEARCHING FOR A STUDENT");
		System.out.print("Enter Student Id:");
		int id = input.nextInt();
		return id;
	}

	public void printStudent(Student model) {
		if (model.getName() == null) {
			System.out.println();
			System.out.println("Student Id does not exist in database");
		}
		else {
		System.out.println();
		System.out.println("Student ID: " + model.getId());
		System.out.println("Name: " + model.getName());
		System.out.println("Department: " + model.getDepartment());
		System.out.println("Math: " + model.getMath());
		System.out.println("Science: " + model.getScience());
		}

	}

	public void printList(ArrayList<Student> list) {
		System.out.println("\nStudent List");
		System.out.printf("%-10s %10s %20s %10s %18s \n", "Student ID", "Name", "Department", "Math", "Science");
		for (int i = 0; i < list.size(); i++) {
			Student model = list.get(i);
			System.out.printf("%-10d \t %-10s \t %-10s \t %-10.2f \t %-10.2f \n", model.getId(), model.getName(), model.getDepartment(), model.getMath(), model.getScience());
		}
	}

	public int printMenu() {
		System.out.println();
		System.out.println("Student Database Application");
		System.out.println("0. Exit");
		System.out.println("1. Save Student");
		System.out.println("2. Search Student");
		System.out.print("Choose:");
		int choice = input.nextInt();
		return choice;

	}
}
