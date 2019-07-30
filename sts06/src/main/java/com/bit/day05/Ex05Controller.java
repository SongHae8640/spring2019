package com.bit.day05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class Ex05Controller {

	@RequestMapping(value="/ex05", method=RequestMethod.GET)
	public String mapping() {
		return "ex05";
	}
	
	@RequestMapping(value="/ex06", method=RequestMethod.POST)
	public String ex06() {
		return "ex06";
	}
}
