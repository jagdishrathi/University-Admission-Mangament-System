package com.valtech.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.valtech.model.AddStudent;
import com.valtech.model.Admin;

@Repository
public class AdminDaoImpl {

	public boolean loginValidate(Connection conn, Admin admin) {
		// TODO Auto-generated method stub
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "SELECT Id,Password FROM admin";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("Query Executed");
			// STEP 4: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String id = rs.getString("Id");
				String password = rs.getString("Password");
				if ((admin.getAdminId()).equals(id) && (admin.getAdminPassword()).equals(password)) {
					System.out.println("Compared with database");
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean addStudent(Connection conn, AddStudent addStudent) {
		// TODO Auto-generated method stub
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String StudentId = addStudent.getStudentId();
			String StudentPassword = addStudent.getStudentPassword();
			System.out.println(StudentId);
			System.out.println(StudentPassword);
			String sql = "Insert into student(SID,S_Password) values('" + StudentId + "','" + StudentPassword + "')";
			statement.executeUpdate(sql);
			System.out.println("Query Executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public ArrayList filterStudent(Connection conn, String branch, String sem) {
		// TODO Auto-generated method stub
		Statement statement = null;
		ArrayList list = new ArrayList();

		try {
			statement = (Statement) conn.createStatement();
			String sql = "Select * from student where S_BranchId='" + branch + "' and S_Sem='" + sem + "';";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("Query Executed");
			// STEP 4: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				ArrayList list1 = new ArrayList();
				String studentId = rs.getString(1);
				String studentName = rs.getString(2);
				String studentBranch = rs.getString(5);
				int studentSem = rs.getInt(6);
				int studentAssignment = rs.getInt(8);

				list1.add(studentId);
				list1.add(studentName);
				list1.add(studentBranch);
				list1.add(studentSem);
				list1.add(studentAssignment);
				list.add(list1);
				System.out.println(list.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	public ArrayList subjectName(Connection conn, String studentBranch, String studentSem) {
		// TODO Auto-generated method stub
		Statement statement = null;
		ArrayList list = new ArrayList();

		try {
			statement = (Statement) conn.createStatement();
			String sql = "Select * from subject where BranchId='" + studentBranch + "' and Sem='" + studentSem + "';";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("Query Executed");
			// STEP 4: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				ArrayList list1 = new ArrayList();
				String subject = rs.getString(1);

				list1.add(subject);
				list.add(list1);
				System.out.println(list.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	public boolean addStudentMarks(Connection conn, String subject1, String subject2, String subject3, String studentId,
			String studentBranch) {
		// TODO Auto-generated method stub
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Insert into studentassignment(StudentId,BranchId,Subject1,Subject2,Subject3) values('"+studentId+"','"+studentBranch+"','"+subject1+"','"+subject2+"','"+subject3+"')";
			statement.executeUpdate(sql);
			System.out.println("Inserted Marks");
			String sql1 = "Update studentassignment set Total=Subject1+Subject2+Subject3;";
			statement.executeUpdate(sql1);
			System.out.println("Updated Successfully");
			String sql2 = "update student s,studentassignment sa set s.S_Assignment=sa.Total where s.SID=sa.StudentId;";
			statement.executeUpdate(sql2);
			System.out.println("Updated Student Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
