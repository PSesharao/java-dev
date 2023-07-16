package com.mindtree.springmvcapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class FlightCustomerHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(CustomerException.class)
	public ModelAndView handleCustomerExceptions(CustomerException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(FlightException.class)
	public ModelAndView handleFlightExceptions(FlightException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}
}
