package com.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//component-scan���� base-package�� com.bit.day05�� �����߱� ������ �Ʒ� Ŭ������ ��ü �������� �ʴ´�.
@Controller
public class Ex04Controller {

	@RequestMapping("/ex04")
	public String ex04() {
		
		return "ex04";
	}
}
