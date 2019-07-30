package com.bit.day05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class Ex05Controller {

	@RequestMapping("/ex05")
	public String mapping() {
		return "ex05";
	}
	
	@RequestMapping("/ex06")
	public String ex06() {
		return "ex06";
	}
}
