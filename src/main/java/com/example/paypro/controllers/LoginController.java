package com.example.paypro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	
	@GetMapping("/login-form")
	public String login() {
		return "login";
	}

}
