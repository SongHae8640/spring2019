package com.bit.day05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class From01Controller {
	
	@RequestMapping("/ex10")
	public String ex09() {
		
		return "form01";
	}
	
	@RequestMapping("/ex11")
	public void ex10(Model model,
			@ModelAttribute("num") int param1, 
			@RequestParam String msg,
			int id){
		model.addAttribute("num", param1);
		model.addAttribute("msg", msg);
		
	}

}
