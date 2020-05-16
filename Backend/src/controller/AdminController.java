package com.example.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.dao.AdminDao;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.ValidationToken;
import com.example.main.repository.ValidationTokenRepository;
import com.example.main.service.EmailService;

@RestController("AdminController")
@RequestMapping(value="",method= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ValidationTokenRepository validationTokenRepository;
	
	private Logger logger=  LoggerFactory.getLogger(AdminController.class);
	
	@PostMapping(path="/addMerchant")
	public String addMerchant(@RequestBody(required = false) MerchantDetails merchant) {
		merchant.setActive(true);
		merchant.setUserId(123456);
		adminDao.addMerchant(merchant);
		return "merchant added";
	}
	
	@PostMapping(path="/addCustomer")
	public String addCustomer(@RequestBody(required = false) CustomerDetails customer) {
		String string="";
		customer.setActive(false);
		customer.seteMail("khushi13ambastha@gmail.com");
		if(adminDao.existingCustomerByEmail(customer.geteMail())==false) {
			adminDao.addCustomer(customer);
			try {
				emailService.sendVerificationMail(customer);
			}catch(MailException ex) {
				logger.info("Error sending email: " + ex.getMessage());
			}
			string="customer added";
		}
		else string="Email already exists!";
		
		return string;
	}
	
	@PostMapping(path="/confirm-account")
	public String confirmUserAccount(String string, @RequestParam("token")String tokenValue) {
		
		ValidationToken token = validationTokenRepository.findByTokenValue(tokenValue);
		if(token !=null) {
			CustomerDetails customer= adminDao.
					findCustomerByEMailIgnoreCase(token.getUser().geteMail());
			customer.setActive(true);
			emailService.sendWelcomeMail(customer);
			adminDao.addCustomer(customer);
			string= "Account verified";
		}
		else {
			string="Account not verified. This link is invalid or broken.";
		}
		return string;
		
	}
	

}
