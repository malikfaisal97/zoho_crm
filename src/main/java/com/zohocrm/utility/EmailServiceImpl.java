package com.zohocrm.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender emailSender;//we cannot import this till we add java dependency in pom.xml email api

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		
		SimpleMailMessage message = new SimpleMailMessage(); 
       // message.setFrom("noreply@baeldung.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);

	}

}
