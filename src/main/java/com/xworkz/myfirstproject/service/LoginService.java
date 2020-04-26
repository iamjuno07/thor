package com.xworkz.myfirstproject.service;

import java.util.Map;

public interface LoginService {

	public Map<String, String> validateAndSave(String email, String password);

}
