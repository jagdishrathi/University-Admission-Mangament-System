package com.valtech.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.valtech.dao.AdminDaoImpl;
import com.valtech.model.AddStudent;
import com.valtech.model.Admin;

@Service
public class AdminServiceImpl {

	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/universityadmissionsystem";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public boolean loginValidation(Admin admin) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			if (adminDaoImpl.loginValidate(conn, admin)) {
				System.out.println("Successfull Execute service");
				return true;
			}

			// STEP 5: Clean-up environment

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return false;
	}

	public boolean addStudent(AddStudent addStudent) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			if (adminDaoImpl.addStudent(conn, addStudent)) {
				System.out.println("Successfull Execute service");
				return true;
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return false;
	}

	public ArrayList filterStudent(String branch, String sem) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			return adminDaoImpl.filterStudent(conn, branch, sem);

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end tr
		return null;

	}

	public ArrayList subjectName(String studentBranch, String studentSem) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			return adminDaoImpl.subjectName(conn, studentBranch, studentSem);

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end tr
		return null;
	}

	public boolean addStudentMarks(String subject1, String subject2, String subject3, String studentId,
			String studentBranch) {
		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			return adminDaoImpl.addStudentMarks(conn,subject1,subject2,subject3,studentId,studentBranch);

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end tr
		return false;
	}
	}
