package com.example.demo.controller;
import com.example.demo.util.MessageSourcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Autowired
	MessageSource messageSource;

	@GetMapping(path = "show")
	@ResponseBody
	public void show() {
		System.out.println("得到国际化配置文件中的value值：");
		System.out.println(MessageSourcUtil.getMessage("200"));
		System.out.println(MessageSourcUtil.getMessage("500"));
		System.out.println(MessageSourcUtil.getMessage("name"));
		System.out.println(MessageSourcUtil.getMessage("pwd"));
	}

}