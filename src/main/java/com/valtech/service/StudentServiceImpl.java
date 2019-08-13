package com.valtech.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.valtech.dao.StudentDaoImpl;
import com.valtech.model.AddStudent;

@Service
public class StudentServiceImpl {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/sample";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static boolean loginValidation(AddStudent student) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (StudentDaoImpl.loginValidate(conn, student)) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return false;
	}

	public static boolean updateProfile(String studentId, String studentName, String studentEmail, String studentBranch,
			String studentSem, String studentPhoneNumber, String studentPassword) {

		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			StudentDaoImpl.updateProfile(conn, studentId, studentName, studentEmail, studentBranch, studentSem,
					studentPhoneNumber, studentPassword);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}

}
