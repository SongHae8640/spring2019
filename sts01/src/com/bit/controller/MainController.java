package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller {
	String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//View�� ���� model�� View�� ��� ���� Ŭ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		//msg�� ������ ��� - ���������δ� ����.
//		request.setAttribute("msg", "ȯ���մϴ�.");
		mav.addObject("msg",msg);
		return mav;
	}

}
