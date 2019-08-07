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
	static final String DB_URL = "jdbc:mysql://localhost:3306/universityadmissionsystem";

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
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 3: Execute a query
			System.out.println("Connected database successfully...");

			if (StudentDaoImpl.loginValidate(conn, student)) {
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

}
