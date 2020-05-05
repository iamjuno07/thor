package com.xworkz.myfirstproject.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xworkz.myfirstproject.dao.SignUpDAO;
import com.xworkz.myfirstproject.dto.SignUpDTO;
import com.xworkz.myfirstproject.entity.SignUpEntity;

@Component
@Qualifier("Service")
public class SignUpServiceImpl implements SignUpService {

	public static final Logger logger = Logger.getLogger(SignUpServiceImpl.class);

	private SignUpDAO dao;
	private MailService mail;

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	@Autowired
	public void setDao(@Qualifier("SignUpDAO") SignUpDAO dao) {
		this.dao = dao;
	}

	@Autowired
	public void setMail(@Qualifier("mailService") MailService mail) {
		this.mail = mail;
	}

	public SignUpServiceImpl() {
		System.out.println("Created\t" + this.getClass().getSimpleName());
	}

	@Override
	public Map<String, String> validateAndSave(SignUpDTO dto) {
		// System.out.println("invoked validateAndSave inside SignUpServiceImpl");
		logger.warn("invoked validateAndSave inside SignUpServiceImpl");
		Map<String, String> map = new HashMap<String, String>();

		try {

			String username = dto.getUsername();
			String email = dto.getEmail();
			String phone = dto.getPhone();
			String course = dto.getCourse();
			String agree = dto.getAgree();

			if (agree.equals("no")) {
				// System.out.println("inside agree validations");
				logger.warn("inside agree validations");
				map.put("Agree", "Please select Agree to proceed");
				return map;
			}

			if (username == null || username.isEmpty()) {
				// System.out.println("inside username validations");
				logger.warn("inside username validations");
				map.put("username", "Username is either null or Empty");
				return map;
			}
			if (email == null || email.isEmpty()) {
				// System.out.println("inside email validations");
				logger.warn("inside email validations");
				map.put("email", "Email is is invalid");
				return map;
			}
			if (phone == null || phone.isEmpty() || phone.length() < 0 || phone.length() > 10) {
				// System.out.println("inside phone validations");
				logger.warn("inside phone validations");
				map.put("PhoneNo", "PhoneNo is invalid");
				return map;
			}
			if (course == null || course.isEmpty() || course.equals("Choose Course...")) {
				// System.out.println("inside course validations");
				logger.warn("inside course validations");
				map.put("Course", "Course is invalid");
				return map;
			}
			String password = generatePassword(8);
			// System.out.println("Generated Password: " + password);
			logger.warn("Generated Password: " + password);
			String AESEncrypt = AESSecurity.encrypt(password, "password");
			// System.out.println("Validate UserName");
			logger.warn("Validate UserName");
			if (this.dao.validateUserName(username)) {
				// System.out.println("Validate Email");
				logger.warn("Validate Email");

				if (this.dao.validateEmail(email)) {
					// System.out.println("Saving UserName");
					logger.warn("Saving UserName");
					SignUpEntity entity = new SignUpEntity();
					entity.setPassword(AESEncrypt);
					entity.setLoginCount(0);
					BeanUtils.copyProperties(dto, entity);
					this.dao.saveUser(entity);
					mail.sendMail("Xworkz.com", email, " Generated Password",
							"Your Generated password is: " + password);
					map.put("Success", "Successfully Registered and password is sent to " + email);
				} else {
					map.put("Email", "Email Already Registered");
				}

			} else {
				map.put("UserName", "UserName Already Registered");
			}
			return map;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	public static String generatePassword(int len) {

		// System.out.println("invoked generatePassword() method");
		logger.warn("invoked generatePassword() method");
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();

	}

}
