package com.xworkz.myfirstproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.myfirstproject.service.ForgotPasswordService;

@Component
@RequestMapping("/")
public class ForgotPasswordController {

	private ForgotPasswordService service;

	public ForgotPasswordController() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	@Autowired
	public void setService(@Qualifier("forgotpassword") ForgotPasswordService service) {
		this.service = service;
	}

	@RequestMapping("/forgotPassword.do")
	public String PasswordUpdate(@RequestParam String email, Model model) {
		System.out.println("invoked forgotPassword()");
		System.out.println("email enterred:" + email);
		Map<String, String> message = this.service.validateAndUpdate(email);
		model.addAttribute("returnForgotMessage", message);
		return "forgotPassword";

	}
}
