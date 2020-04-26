package com.xworkz.myfirstproject.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.myfirstproject.dto.SignUpDTO;
import com.xworkz.myfirstproject.service.SignUpService;

@Component
@RequestMapping("/")
public class SignUpController {

	private SignUpService service;

	public SignUpController() {
		System.out.println("Created\t" + this.getClass().getSimpleName());
	}

	@Autowired
	public void setService(@Qualifier("Service") SignUpService service) {
		this.service = service;
	}

	@RequestMapping("/signUp.do")
	public String signUp(@ModelAttribute SignUpDTO signUp, Model model) {
		System.out.println("invoked signUp  inside SignUpController");
		System.out.println(signUp.getUsername());
		System.out.println(signUp.getEmail());
		System.out.println(signUp.getPhone());
		System.out.println(signUp.getCourse());
		System.out.println(signUp.getAgree());

		Map<String, String> message = this.service.validateAndSave(signUp);
		model.addAttribute("dto", signUp);
		model.addAttribute("returnMessage",message);
		return "signUp";
	}

}
