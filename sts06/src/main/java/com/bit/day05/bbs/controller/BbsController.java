package com.bit.day05.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.day05.model.Day02Dao;
import com.bit.day05.model.entity.Day02Vo;

@Controller
@RequestMapping("/bbs")
public class BbsController {
	//이름 그래도 자동으로 연결
	@Autowired(required = false)
	Day02Dao day02Dao;
	

	public void setDay02Dao(Day02Dao day02Dao) {
		this.day02Dao = day02Dao;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("alist", day02Dao.selectAll());
		return "bbs/list";
	}
	
	@RequestMapping("/add")
	public void add() {	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute("bean") Day02Vo bean) {
		day02Dao.insertOne(bean);
		return "redirect:list";
	}
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		int num;
		try {
			num= Integer.parseInt(request.getParameter("idx"));
			model.addAttribute("bean", day02Dao.selectOne(num));
		} catch (Exception e) {
			return "redirect:list";
		}
		return "bbs/detail";
		
	}
	
	@RequestMapping(value="/editDelete", method = RequestMethod.POST)
	public String editDelete(@RequestParam String editDelete, 
							@ModelAttribute("bean") Day02Vo bean,
							Model model) {
		System.out.println(editDelete);
		if(editDelete.equals("edit")) {
			model.addAttribute("bean", bean);
			return "bbs/edit";
		}else if(editDelete.equals("delete")) {
			System.out.println(bean.getNum());
			day02Dao.deleteOne(bean.getNum());
			return "redirect:list";
		}	
		return "redirect:list";	
	}

	@RequestMapping(value="/updateCancel", method = RequestMethod.POST)
	public String updateCancel(@RequestParam String updateCancel, 
							@ModelAttribute("bean") Day02Vo bean,
							Model model) {
		if(updateCancel.equals("update")) {
			day02Dao.updateOne(bean);
			model.addAttribute("bean", bean);
			return "bbs/detail";
		}else if(updateCancel.equals("cancel")) {
			model.addAttribute("bean", bean);
			return "bbs/edit";
		}	
		return "redirect:list";	
	}
	
	
	/////////////////////////////////////////
	///////강사님 방식///////////////////////
	@RequestMapping(value="/add2", method = RequestMethod.GET)
	public void add2() {}
	
	@RequestMapping(value="/add2", method = RequestMethod.POST)
	public String add2(@ModelAttribute Day02Vo bean) {
		day02Dao.insertOne(bean);
		return "redirect:list";
	}
	
	@RequestMapping("detail2")
	public void one(@RequestParam("idx") int num, Model model) {
		model.addAttribute("bean", day02Dao.selectOne(num));
	}
}
