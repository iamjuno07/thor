package com.xworkz.myfirstproject.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xworkz.myfirstproject.dao.LoginDAO;
import com.xworkz.myfirstproject.entity.SignUpEntity;

@Component
@Qualifier("serviceImpl")
public class LoginServiceImpl implements LoginService {

	public LoginServiceImpl() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	private LoginDAO dao;

	@Autowired
	public void setDao(@Qualifier("DAOImpl") LoginDAO dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, String> validateAndSave(String email, String password) {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("invoked validateAndSave inside LoginServiceImpl");
		if (email == null || email.isEmpty()) {
			System.out.println("inside email validations");
			map.put("email", "Email is is invalid");
			return map;
		}
		int count = this.dao.validateLoginEmail(email);
		System.out.println("First CountValue:" + count);
		// if count is equal to 1 then its unique email-id
		if ((count == 1)) {
			SignUpEntity entity = this.dao.getUserData(email);
			int loginCount = entity.getLoginCount();
			if (entity.getLoginCount() > 3) {
				System.out.println("Validating LoginCounts greater than 3");
				map.put("Login", "Login Count exceeded account is blocked");
				return map;
			} else {
				System.out.println("Validating LoginCounts less than 3");
				String AESDecrypt = AESSecurity.decrypt(entity.getPassword(), "password");
				if (AESDecrypt.equals(AESDecrypt)) {
					System.out.println("Password matched");
					this.dao.updateLoginCount(email, 0);
					map.put("Success", "Login Successfull");
					return map;

				} else {
					System.out.println("Password didnt match so increment loginCount");
					System.out.println("Inside CountValue:" + loginCount);
					System.out.println("Email:" + email);
					this.dao.updateLoginCount(email, ++loginCount);
				}
			}
		}
		map.put("email", "Email or password is incorrect");
		return map;
	}

}
