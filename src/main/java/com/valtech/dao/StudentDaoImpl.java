package com.valtech.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.valtech.model.AddStudent;

public class StudentDaoImpl {

	public static boolean loginValidate(Connection conn, AddStudent student) {
		// TODO Auto-generated method stub
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "SELECT SID,S_Password FROM student";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("Query Executed");
			// STEP 4: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String id = rs.getString("SId");
				String password = rs.getString("S_Password");
				if ((student.getStudentId()).equals(id) && (student.getStudentPassword()).equals(password)) {
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

}
