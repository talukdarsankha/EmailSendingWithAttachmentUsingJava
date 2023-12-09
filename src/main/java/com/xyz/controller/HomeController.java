package com.xyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.xyz.entity.UserMail;
import com.xyz.service.UserMailService;

@Controller
public class HomeController {
	
	@Autowired
	private UserMailService ums;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/send")
	public String getMessage(@ModelAttribute UserMail userMail) {
		System.out.println(userMail);
		ums.sendMail(userMail);
		return "redirect:/";
	}
	

}
