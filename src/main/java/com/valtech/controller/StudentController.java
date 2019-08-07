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
	
	ModelAndView mav= new ModelAndView();

	@RequestMapping(value = "/StudentLogin")
	public String home() {
		return "StudentLogin";
	}
	
	@RequestMapping(value = "/studentLoginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("studentLogin") AddStudent student) {
		if (StudentServiceImpl.loginValidation(student)) {
			mav.setViewName("StudentHome");
		} else {
			mav.setViewName("StudentLogin");
			mav.addObject("message", "Invalid Username or Password");
		}
		return mav;
	}

}
