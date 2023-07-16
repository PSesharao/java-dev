package com.mindtree.carproject.exception.globalexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(Exception.class)

	public ModelAndView handleAllExceptions(Exception exception) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
		
	}

	@ExceptionHandler(BrandException.class)
	public ModelAndView handleBrandExceptions(BrandException exception) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(ColorException.class)
	public ModelAndView handleColorExceptions(ColorException exception) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(ModelException.class)
	public ModelAndView handleModelExceptions(ModelException exception) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(ModelColorException.class)
	public ModelAndView handleModelColorExceptions(ModelColorException exception) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", exception.getLocalizedMessage());
		mv.setViewName("error");
		return mv;
	}
}
