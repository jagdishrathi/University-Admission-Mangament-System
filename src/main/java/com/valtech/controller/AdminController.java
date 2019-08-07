package com.valtech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.model.AddStudent;
import com.valtech.model.Admin;
import com.valtech.service.AdminServiceImpl;

@Controller
public class AdminController {

	AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
	ModelAndView mav = new ModelAndView();
	private String branch,sem;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/universityadmissionsystem";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	@RequestMapping(value = "/AdminLogin")
	public String admin() {
		return "AdminLogin";
	}

	@RequestMapping(value = "/AdminStudent")
	public String adminStudent() {
		return "AdminStudent";
	}

	@RequestMapping(value = "/AdminAddStudent")
	public String adminAddStudent() {
		return "/AdminAddStudent";
	}

	@RequestMapping(value = "/AdminHome")
	public String adminHome() {
		return "/AdminHome";
	}

	@RequestMapping(value = "/AdminStudentFilter")
	public String adminStudentFilter() {
		return "/AdminStudentFilter";
	}

	@RequestMapping(value = "/FacultyLogin")
	public String faculty() {
		return "FacultyLogin";
	}
	

	@RequestMapping(value = "/AdminLogin", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("adminlogin") Admin admin) {
		if (adminServiceImpl.loginValidation(admin)) {
			mav.setViewName("AdminHome");
		} else {
			mav.setViewName("AdminLogin");
			mav.addObject("message", "Invalid Username or Password");
		}
		return mav;
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("addstudent") AddStudent addStudent) {
		boolean message = adminServiceImpl.addStudent(addStudent);
		if (message == true) {
			mav.setViewName("AdminAddStudent");
			mav.addObject("message", "Successfully Added Student");
		} else {
			mav.setViewName("AdminAddStudent");
			mav.addObject("message", "Student is Already Added");
		}
		return mav;
	}

	@RequestMapping(value = "/AdminStudentPerformance", method = RequestMethod.POST)
	public ModelAndView studentFilter(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("adminStudentFilter") AddStudent addStudent) {
		branch = request.getParameter("branchId");
		sem = request.getParameter("semId");
		ModelAndView mav = new ModelAndView();
		ArrayList studentFilter = adminServiceImpl.filterStudent(branch, sem);
		mav.addObject("studentPerformance", studentFilter);
		mav.setViewName("AdminStudentPerformance");
		return mav;
	}

	@RequestMapping(value = "/AdminStudentAssignment", method = RequestMethod.POST)
	public ModelAndView adminStudentAssignment(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("adminStudentAssignment") AddStudent addStudent) {
	    String studentId = request.getParameter("studentId");
		String studentname = request.getParameter("studentName");
		String studentBranch = request.getParameter("studentBranch");
		String studentSem = request.getParameter("studentSem");
		mav.addObject("Id", studentId);
		mav.addObject("name", studentname);
		mav.addObject("branch", studentBranch);
		mav.addObject("sem", studentSem);
		ArrayList subject = adminServiceImpl.subjectName(studentBranch, studentSem);
		mav.addObject("subject", subject);
		mav.setViewName("AdminStudentAssignment");
		return mav;
	}
	
	@RequestMapping(value="/adminSubjectMarks",method=RequestMethod.POST)
	public ModelAndView adminSubjectMarks(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("adminSubjectMarks") AddStudent addStudent) {
		System.out.println("Subject");
		String subject1=request.getParameter("subject1");
		String subject2=request.getParameter("subject2");
		String subject3=request.getParameter("subject3");
		String studentId = request.getParameter("Id");
		String studentBranch=request.getParameter("branch");
		boolean message = adminServiceImpl.addStudentMarks(subject1,subject2,subject3,studentId,studentBranch);
		if(message==true) {
			mav.setViewName("AdminStudentFilter");
			mav.addObject("message", "Successfully Marks Added");
		}
		else {
			mav.setViewName("AdminStudentAssignment");
			mav.addObject("message", "Marks already added");
		}
		return mav;
	}
}
