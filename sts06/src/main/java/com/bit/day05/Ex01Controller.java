package com.bit.day05;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
public class Ex01Controller implements Controller {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	@RequestMapping("/ex01")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("ex01");
		mav.addObject("msg","»Ï·Î·Õ");
		return mav;
	}
	
	@RequestMapping("/ex09")
	public String ex09(Model model) {
		model.addAttribute("msg", "»Ï·Î·Õ2");
		return "ex01";
	}
	
	@RequestMapping(value="/ex07.bit")
	public void ex07(HttpServletRequest req) {
		req.setAttribute("msg", "msg Àü´Þ");
		log.debug("Ex01Controller :: ex07() ");
	}
	
	@RequestMapping("/ex08")
	public View Ex08() {
		return new View() {
			
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				log.debug("ex08 render()");
				PrintWriter out = response.getWriter();
				out.print("test page");
			}
			
			@Override
			public String getContentType() {
				log.debug("ex08 getContentType()");
				return null;
			}
		};
	}

}
