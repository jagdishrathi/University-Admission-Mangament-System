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
public class AdminServiceImpl implements AdminService {

	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/sample";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public boolean loginValidation(Admin admin) {
		Connection conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (adminDaoImpl.loginValidate(conn, admin)) {
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

	public boolean addStudent(AddStudent addStudent) {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (adminDaoImpl.addStudent(conn, addStudent)) {
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

	public ArrayList filterStudent(String branch, String sem) {

		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			return adminDaoImpl.filterStudent(conn, branch, sem);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			return adminDaoImpl.subjectName(conn, studentBranch, studentSem);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

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

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			return adminDaoImpl.addStudentMarks(conn, subject1, subject2, subject3, studentId, studentBranch);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

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
