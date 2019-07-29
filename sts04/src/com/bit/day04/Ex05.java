package com.bit.day04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.day04.module.Module;

public class Ex05 {
	public static void main(String[] args) {
		String filename="classpath:/applicationContext.xml";

		ApplicationContext ctxt = null;
		//ctxt =new ClassPathXmlApplicationContext(filename);
		String path = "C:\\java\\workspace4\\sts04\\src\\";
		//String path = "./target/classes/";
		//ctxt=new FileSystemXmlApplicationContext(path + filename);
		ctxt = new GenericXmlApplicationContext(filename); //ÆÐÅ°Â¡ ±âÁØ
		Module mod = (Module)ctxt.getBean("mod");
		System.out.println(mod.getMsg());
	}
}
