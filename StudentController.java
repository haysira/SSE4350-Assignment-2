package com.sse4350.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sse4350.model.Student;
import com.sse4350.view.StudentView;

public class StudentController {
	private Student model;
	private StudentView view;

	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;

	}
	
public StudentController() {
	super();
	// TODO Auto-generated constructor stub
}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	ResultSetMetaData rsmd = null;
	
	public Student getStudent(int num) {

		try {
			connection = DBConnectionUtil.openConnection();
			String sql = "Select * from student where IdStudent =" + num;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				model.setId(Integer.parseInt(resultSet.getString("IdStudent")));
				model.setName(resultSet.getString("Name"));
				model.setDepartment(resultSet.getString("Department"));
				model.setMath(resultSet.getDouble("Math"));
				model.setScience(resultSet.getDouble("Science"));
			}
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public void saveStudent(Student model) {
		try {
			connection = DBConnectionUtil.openConnection();
			String sql = "Insert into student (IdStudent, Name, Department, Math, Science) values " + "('" + model.getId() + "','"
					+ model.getName() + "','" + model.getDepartment() + "','" + model.getMath() + "','" + model.getScience() + "')";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			System.out.println("Student saved!");
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Error: Student Id already exists in database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> listStudent() {
		ArrayList<Student> list = new ArrayList<>();
		try {
			connection = DBConnectionUtil.openConnection();
			String sql = "Select * from student";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			rsmd = resultSet.getMetaData();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("IdStudent");
				String name = resultSet.getString("Name");
				String department = resultSet.getString("Department");
				double math =  resultSet.getDouble("Math");
				double science =  resultSet.getDouble("Science");
				list.add(new Student(id, name, department, math, science));
			}
		
			view.printList(list);
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateView(int choice) {
		switch (choice) {
		case 1:
			saveStudent(view.inputForm());
			break;
		case 2:
			view.printStudent(getStudent(view.searchForm()));
			break;
		default:
			break;

		}
	}
}
