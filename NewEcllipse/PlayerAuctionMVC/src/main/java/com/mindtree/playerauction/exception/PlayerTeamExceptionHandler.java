package com.mindtree.playerauction.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class PlayerTeamExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(TeamException.class)
	public ModelAndView handleAllTeamExceptions(TeamException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(PlayerException.class)
	public ModelAndView handleAllPlayerExceptions(PlayerException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}
}
