package com.bit.day05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex02Controller {

	//원하는 만큼 받아 쓰는 것도 가능
	@RequestMapping("/ex02")
	public String mapping(Model model, HttpServletRequest req, HttpServletResponse reps) {
		
		return "ex02";
	}
}
