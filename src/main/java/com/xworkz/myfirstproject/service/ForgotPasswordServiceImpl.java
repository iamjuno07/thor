package com.xworkz.myfirstproject.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xworkz.myfirstproject.dao.ForgotDAO;

@Component
@Qualifier("forgotpassword")
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	private ForgotDAO dao;

	public ForgotPasswordServiceImpl() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	@Autowired
	public void setDao(ForgotDAO dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, String> validateAndUpdate(String email) {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("invoked validateAndUpdate inside ForgotPasswordServiceImpl");
		if (email == null || email.isEmpty()) {
			System.out.println("inside email validations");
			map.put("email", "Email is is invalid");
			return map;
		}

		try {

			int count = this.dao.validateLoginEmail(email);
			System.out.println("First CountValue:" + count);
			// if count is equal to 1 then its unique email-id
			if ((count == 1)) {
				String password = SignUpServiceImpl.generatePassword(8);
				System.out.println("Generated Password: " + password);
				String AESEncrypt = AESSecurity.encrypt(password, "password");
				boolean status = this.dao.updatePassword(email, AESEncrypt);
				if (status) {
					map.put("Password", password);
				}
				return map;
			} else {
				System.out.println("No email found");
				map.put("Error", "Email doesnt exits");
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
