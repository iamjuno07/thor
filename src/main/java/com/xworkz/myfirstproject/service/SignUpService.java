package com.xworkz.myfirstproject.service;

import java.util.Map;

import com.xworkz.myfirstproject.dto.SignUpDTO;

public interface SignUpService {

	public Map<String, String> validateAndSave(SignUpDTO dto);

}
