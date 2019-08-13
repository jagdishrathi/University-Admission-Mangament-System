package com.valtech.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.valtech.model.AddStudent;
import com.valtech.model.Admin;

public interface AdminDao {

	public boolean loginValidate(Connection conn, Admin admin);

	public boolean addStudent(Connection conn, AddStudent addStudent);

	public ArrayList filterStudent(Connection conn, String branch, String sem);

	public ArrayList subjectName(Connection conn, String studentBranch, String studentSem);

	public boolean addStudentMarks(Connection conn, String subject1, String subject2, String subject3, String studentId,
			String studentBranch);

}
