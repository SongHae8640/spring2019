package com.bit.day05.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.day05.model.Day02Dao;

@Controller
@RequestMapping("/bbs")
public class BbsController {
	//이름 그래도 자동으로 연결
	@Autowired
	Day02Dao day02Dao;
	

	public void setDay02Dao(Day02Dao day02Dao) {
		this.day02Dao = day02Dao;
	}

	@RequestMapping({"/list","/"})
//	@RequestMapping("/list")
	public void list(Model model) {
		model.addAttribute("alist", day02Dao.selectAll());
	}
}
