package com.xworkz.myfirstproject.controller;

import java.util.Map;

import org.apache.log4j.Logger;
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

	public static final Logger logger = Logger.getLogger(SignUpController.class);

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
		// System.out.println("invoked signUp inside SignUpController");
		logger.warn("invoked signUp  inside SignUpController");
		// System.out.println(signUp.getUsername());
		logger.warn(signUp.getUsername());
		// System.out.println(signUp.getEmail());
		logger.warn(signUp.getEmail());
		// System.out.println(signUp.getPhone());
		logger.warn(signUp.getPhone());
		// System.out.println(signUp.getCourse());
		logger.warn(signUp.getCourse());
		System.out.println(signUp.getAgree());
		logger.warn(signUp.getAgree());

		Map<String, String> message = this.service.validateAndSave(signUp);
		model.addAttribute("dto", signUp);
		model.addAttribute("returnMessage", message);
		return "signUp";
	}

}
