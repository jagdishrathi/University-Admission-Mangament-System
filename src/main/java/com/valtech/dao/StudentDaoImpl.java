package com.valtech.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.valtech.model.AddStudent;

@Repository
public class StudentDaoImpl{

	public static boolean loginValidate(Connection conn, AddStudent student) {
		// TODO Auto-generated method stub
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "SELECT SID,S_Password FROM student";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				String id = rs.getString("SId");
				String password = rs.getString("S_Password");
				if ((student.getStudentId()).equals(id) && (student.getStudentPassword()).equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static boolean updateProfile(Connection conn, String studentId,String studentName, String studentEmail, String studentBranch,
			String studentSem, String studentPhoneNumber, String studentPassword) {
		
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Update student set S_Name='"+studentName+"',S_Email='"+studentEmail+"',S_PhoneNumber='"+studentPhoneNumber+"',S_BranchId='"+studentBranch+"',S_Sem='"+studentSem+"',S_Password='"+studentPassword+"'where SID='"+studentId+"';";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
