package com.xworkz.myfirstproject.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class SignUpDTO {

	private String username;
	private String email;
	private String phone;
	private String course;
	private String agree;
}
