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
public class AdminDaoImpl implements AdminDao{

	public boolean loginValidate(Connection conn, Admin admin) {

		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "SELECT Id,Password FROM admin";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				String id = rs.getString("Id");
				String password = rs.getString("Password");
				if ((admin.getAdminId()).equals(id) && (admin.getAdminPassword()).equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean addStudent(Connection conn, AddStudent addStudent) {

		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String StudentId = addStudent.getStudentId();
			String StudentPassword = addStudent.getStudentPassword();
			String sql = "Insert into student(SID,S_Password) values('" + StudentId + "','" + StudentPassword + "')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public ArrayList filterStudent(Connection conn, String branch, String sem) {

		Statement statement = null;
		ArrayList list = new ArrayList();

		try {
			statement = (Statement) conn.createStatement();
			String sql = "Select * from student where S_BranchId='" + branch + "' and S_Sem='" + sem + "';";
			ResultSet rs = statement.executeQuery(sql);

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
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList subjectName(Connection conn, String studentBranch, String studentSem) {

		Statement statement = null;
		ArrayList list = new ArrayList();

		try {
			statement = (Statement) conn.createStatement();
			String sql = "Select * from subject where BranchId='" + studentBranch + "' and Sem='" + studentSem + "';";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				ArrayList list1 = new ArrayList();
				String subject = rs.getString(1);

				list1.add(subject);
				list.add(list1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public boolean addStudentMarks(Connection conn, String subject1, String subject2, String subject3, String studentId,
			String studentBranch) {

		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Insert into studentassignment(StudentId,BranchId,Subject1,Subject2,Subject3) values('"
					+ studentId + "','" + studentBranch + "','" + subject1 + "','" + subject2 + "','" + subject3 + "')";
			statement.executeUpdate(sql);

			String sql1 = "Update studentassignment set Total=Subject1+Subject2+Subject3;";
			statement.executeUpdate(sql1);

			String sql2 = "update student s,studentassignment sa set s.S_Assignment=sa.Total where s.SID=sa.StudentId;";
			statement.executeUpdate(sql2);

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}
}
