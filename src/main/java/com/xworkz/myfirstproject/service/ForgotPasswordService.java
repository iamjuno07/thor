package com.xworkz.myfirstproject.service;

import java.util.Map;

public interface ForgotPasswordService {

	public Map<String, String> validateAndUpdate(String email);

}
