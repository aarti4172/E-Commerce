package com.example.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.main.model.User;
import com.example.main.model.ValidationToken;
import com.example.main.repository.ValidationTokenRepository;

@Service("EmailService")
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private ValidationTokenRepository validationTokenRepository;
	private Logger logger= LoggerFactory.getLogger(EmailService.class);
	
	public void sendVerificationMail(User user) throws MailException{
		
		ValidationToken validationToken= new ValidationToken(user);
		logger.info("token=" + validationToken.toString());
		validationTokenRepository.save(validationToken);
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.geteMail());
		mail.setSubject("Complete Registration!");
		mail.setText("To confirm your account, please click here : "
	            +"http://localhost:9090/confirm-account?token="
				+ validationToken.getTokenValue());
		
		javaMailSender.send(mail);
	}
	
	public void sendWelcomeMail(User user) throws MailException{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.geteMail());
		mail.setSubject("Welcome to Capstore.");
		mail.setText("Hi "+ user.getName()+ ",  you have been successfully registered."
				+ "Thank you for choosing us.");
		
		javaMailSender.send(mail);
		
	}
	
	public void sendInvitationMail(String email) throws MailException{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Invitation to Capstore!");
		mail.setText("We are inviting you to join Capstore as a merchant, please click here : "
	            +"http://localhost:8080/Capstore/admin/addMerchant");
		
		javaMailSender.send(mail);
	}
	
	
	

}
