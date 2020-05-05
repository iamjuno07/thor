package com.xworkz.myfirstproject.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.myfirstproject.dto.LoginDTO;
import com.xworkz.myfirstproject.service.LoginService;

@Component
@RequestMapping("/")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	private LoginService service;


	@Autowired
	public void setService(@Qualifier("serviceImpl") LoginService service) {
		this.service = service;
	}

	@RequestMapping("/login.do")
	public String login(@ModelAttribute LoginDTO login, Model model) {
		// System.out.println("invoked login inside LoginController ");
		logger.warn("invoked login inside LoginController ");
		// System.out.println("Email is :" + login.getEmail());
		logger.warn("Email is :" + login.getEmail());
		Map<String, String> message = this.service.validateAndSave(login.getEmail(), login.getPassword());
		model.addAttribute("returnLoginMessage", message);

		if (message.containsKey("Success")) {
			return "home";
		} else {
			return "login";
		}
	}
}
