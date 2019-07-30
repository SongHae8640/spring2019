package com.bit.day05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsListController implements org.springframework.web.servlet.mvc.Controller{


	@Override
//	@RequestMapping(value= {"/bbs/list","/bbs/","/bbs"})
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("", attributeValue)
		mav.setViewName("bbs/list");
		return mav;
	}
}
