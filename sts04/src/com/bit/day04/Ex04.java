package com.bit.day04;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.day04.module.Module5;

public class Ex04 {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		Module5 mod = (Module5)ctxt.getBean("mod5");
		System.out.println(Arrays.deepToString(mod.getArr()));
		System.out.println(mod.getList());
		System.out.println(mod.getSet());
		System.out.println(mod.getMap());
	}
}
