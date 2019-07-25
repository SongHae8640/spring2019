package com.bit.day02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.day02.model.Day02Dao;
import com.bit.day02.model.entity.Day02Vo;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(request.getMethod().equals("POST")) {

			mav.setViewName("redirect:list.bit");
		}else {
			mav.setViewName("add");
			
		}		
		return mav;
	}

}
