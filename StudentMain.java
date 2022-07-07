package com.sse4350;
import java.sql.SQLException;

import com.sse4350.DAO.StudentController;
import com.sse4350.model.Student;
import com.sse4350.view.StudentView;

public class StudentMain {
	public static Student model = new Student();
	public static StudentView view = new StudentView();
	public static StudentController scl = new StudentController(model, view);
	
	public static void main(String[] args) throws SQLException {
		scl.listStudent();
		
		int loop = 0;
		do {
			loop = view.printMenu();
			scl.updateView(loop);
		}while(loop == 1 || loop == 2);
		scl.listStudent();
			
	}
	
}
