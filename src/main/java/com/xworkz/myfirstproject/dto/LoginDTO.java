package com.xworkz.myfirstproject.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class LoginDTO {

	public LoginDTO() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	private String email;
	private String password;
}
