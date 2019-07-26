package com.bit.day03.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.day03.model.Day02Dao;
import com.bit.day03.model.entity.Day02Vo;

public class UpdateController extends AbstractCommandController {
	private Day02Dao dao;
	
	public void setDao(Day02Dao dao) {	
		this.dao = dao;
	}
	
	//handle() 전에 수행되는 메서드
	//수행 전에 check 해야할 내용을 확인하고 되돌릴지 정상 수행시킬지 결정
	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {
		Day02Vo bean = (Day02Vo) command;
		
		if((bean.getSub().trim().isEmpty())) {
			ObjectError error = new ObjectError("sub", "제목 없음");
			errors.addError(error);
		}else if(bean.getContent().trim().isEmpty()) {
			ObjectError error = new ObjectError("content", "내용 없음");
			errors.addError(error);
		}
		
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		Day02Vo bean = (Day02Vo) command;
		ModelAndView mav = new ModelAndView();
		
		//에러가 있는지 확인
		if(errors.hasErrors()) {
			System.out.println(errors.getErrorCount());
			List<ObjectError> errs= errors.getAllErrors();
			for (ObjectError err : errs) {
				System.out.println(err.getObjectName()+" : "+err.getDefaultMessage());
			}
			mav.addObject("bean", dao.selectOne(bean.getNum()));
			mav.addObject("isDetail", false);
			mav.setViewName("detail");
			return mav;
		}else {
			
		}
		
		
		dao.updateOne(bean);
		mav.setViewName("redirect:detail.bit?idx="+bean.getNum());
		return mav;
	}

}
