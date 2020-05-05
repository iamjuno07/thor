package com.xworkz.myfirstproject.service;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mailService")
public class MailServiceImpl implements MailService {

	private static final Logger logger = Logger.getLogger(MailServiceImpl.class);
	private MailSender mailSender;

	public MailServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	

	@Override
	public void sendMail(String from, String to, String subject, String msg) {

		logger.warn("invoked sendMail()");
		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(msg);

		try {
			mailSender.send(mail);
		} catch (MailException e) {
			logger.warn("Exception :", e);
		}

	}
}
