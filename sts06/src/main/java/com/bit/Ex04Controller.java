package com.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04Controller {

	@RequestMapping("/ex04")
	public String ex04() {
		
		return "ex04";
	}
}
