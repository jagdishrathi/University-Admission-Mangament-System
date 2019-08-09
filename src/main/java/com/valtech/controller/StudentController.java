package com.valtech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.model.AddStudent;
import com.valtech.model.Admin;
import com.valtech.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	private String studentId,studentName,studentEmail,studentBranch,studentSem,studentPhoneNumber;
	ModelAndView mav= new ModelAndView();
	
	@RequestMapping(value = "/welcome1")
	public String logout() {
		return "welcome1";
	}
	
	@RequestMapping(value = "/StudentLogin")
	public String login() {
		return "StudentLogin";
	}
	
	@RequestMapping(value = "/StudentUpdateProfile")
	public String home(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("updateStudentProfile") AddStudent student) {
		studentId=request.getParameter("studentId");
		return "StudentUpdateProfile";
	}
	
	@RequestMapping(value = "/StudentHome")
	public String updateStudent() {
		return "StudentHome";
	}
	
	@RequestMapping(value = "/StudentPerformance")
	public String studentPerformance() {
		return "StudentPerformance";
	}
	
	@RequestMapping(value = "/studentLoginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("studentLogin") AddStudent student) {
		if (StudentServiceImpl.loginValidation(student)) {
			mav.addObject("studentID", student.getStudentId());
			mav.setViewName("StudentHome");
		} else {
			mav.setViewName("StudentLogin");
			mav.addObject("message", "Invalid Username or Password");
		}
		return mav;
	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("updateStudent") AddStudent student) {
		studentId=request.getParameter("sid");
		studentName=request.getParameter("name");
		studentEmail=request.getParameter("email");
		studentBranch=request.getParameter("branch");
		studentSem=request.getParameter("sem");
		studentPhoneNumber=request.getParameter("phonenumber");
		String studentPassword=request.getParameter("password");
		System.out.println(studentName);
		StudentServiceImpl.updateProfile(studentId,studentName,studentEmail,studentBranch,studentSem,studentPhoneNumber,studentPassword);
		mav.setViewName("StudentHome");
		return mav;
	}
}
