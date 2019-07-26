package com.bit.day03.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.day03.model.Day02Dao;

public class DeleteController extends AbstractController{
	private Day02Dao dao;
	
	public void setDao(Day02Dao dao) {
		this.dao = dao;
	}
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		dao.updateOne(Integer.parseInt(request.getParameter("num")));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list.bit");
		System.out.println(mav.toString());
		return mav;
	}

}
