package com.valtech.service;

import java.util.ArrayList;

import com.valtech.model.AddStudent;
import com.valtech.model.Admin;

public interface AdminService {
	
	public boolean loginValidation(Admin admin);
	
	public boolean addStudent(AddStudent addStudent);
	
	public ArrayList filterStudent(String branch, String sem);
	
	public ArrayList subjectName(String studentBranch, String studentSem);
	
	public boolean addStudentMarks(String subject1, String subject2, String subject3, String studentId,
			String studentBranch);

}
