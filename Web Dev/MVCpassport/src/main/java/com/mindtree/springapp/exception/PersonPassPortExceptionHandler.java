package com.mindtree.springapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice

public class PersonPassPortExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(DuplicatePassportException.class)
	public ModelAndView handleDuplicatePassportExceptions(DuplicatePassportException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(PersonIssueException.class)
	public ModelAndView handlePersonIssueExceptions(PersonIssueException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getMessage());
		mv.setViewName("error");
		return mv;
	}

}
