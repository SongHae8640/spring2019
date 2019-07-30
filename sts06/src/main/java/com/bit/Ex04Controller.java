package com.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//component-scan에서 base-package를 com.bit.day05로 지정했기 때문에 아래 클래스는 객체 생성되지 않는다.
@Controller
public class Ex04Controller {

	@RequestMapping("/ex04")
	public String ex04() {
		
		return "ex04";
	}
}
