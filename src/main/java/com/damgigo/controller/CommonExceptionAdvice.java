package com.damgigo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/commonError");
		modelAndView.addObject("exception", ex);
		
		return modelAndView;
	}
}
