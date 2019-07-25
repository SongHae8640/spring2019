package com.bit.day02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {
	Logger log = Logger.getLogger(this.getClass()); //IndexController.class, com.bit.day02.controller.IndexController

	public IndexController() {
		log.debug("Create IndexController");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Call IndexController.handleRequest()");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		return mav;
	}

}
