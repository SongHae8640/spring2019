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
		//View에 보낼 model과 View를 모두 지닌 클래스
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		//msg를 보내는 방법 - 내부적으로는 같다.
//		request.setAttribute("msg", "환영합니다.");
		mav.addObject("msg",msg);
		return mav;
	}

}
