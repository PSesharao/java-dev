package com.mindtree.springmvcapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class StudentDepartmentHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(StudentException.class)
	public ModelAndView handleStudentExceptions(StudentException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(DepartmentException.class)
	public ModelAndView handleDepartmentExceptions(DepartmentException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}
}
