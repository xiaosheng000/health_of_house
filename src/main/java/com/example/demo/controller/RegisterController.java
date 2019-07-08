package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Admin;
import com.example.demo.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/re.action", method = RequestMethod.POST)
	
	public String register(Model model, Admin admin,@RequestParam("username") String username) {	
		Object obj = registerService.findAllByCode(username);
		if(obj == null) {
			registerService.registerUser(admin);
			System.out.println("注册成功！");
			return "/WEB-INF/views/registerSuccess.jsp";
		}
		model.addAttribute("msg", "用户已存在，请重新输入！");
		return "/WEB-INF/views/register.jsp";
	}
}
