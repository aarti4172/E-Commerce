package com.example.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.main.controller.AdminController;
import com.example.main.model.Coupon;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.repository.CommonFeedbackRepository;
import com.example.main.repository.ConfirmationTokenRepository;
import com.example.main.repository.CouponRepository;
import com.example.main.repository.CustomerRepository;
import com.example.main.repository.MerchantRepository;
import com.example.main.repository.ProductRepository;
import com.example.main.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
class ControllerTests {
	
	@Autowired
	private AdminController admincontroller;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	MerchantRepository merchantRepository;
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired
	CouponRepository couponRepo;
	
	@Autowired 
	CommonFeedbackRepository commonRepo;
	
	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("All test cases for Controller layer starting...");
	}
	
	@BeforeEach
	void setup() {
		System.out.println("Test Case Started");
	}

	@AfterEach
	void tearDown() {
		System.out.println("Test Case Over");	
	}
	
	@AfterAll
	static void setUpAfterClass() {
		System.out.println("All test cases ended.");
	}

	
	//test users
	
	@Test
	@Rollback(true)
	public void testgetAllCustomers() {
		CustomerDetails customerDetail = new CustomerDetails("Roxane", "roxy", "roxy3996", "roxy@gmail.com", "User",
				true, "What is your petname", "Roxy", "3456789012", "2345678901", "rox@gmail.com", "India", null, null,
				null, null, null);
		customerRepository.save(customerDetail);
		assertNotNull(admincontroller.getAllCustomers());
	}
	
	@Test
	@Rollback(true)
	public void testDeleteCustomer() {
		CustomerDetails customerDetail = new CustomerDetails("Roxane", "roxy", "roxy3996", "roxy@gmail.com", "User",
				true, "What is your petname", "Roxy", "3456789012", "2345678901", "rox@gmail.com", "India", null, null,
				null, null, null);
		customerRepository.save(customerDetail);
		int id = customerDetail.getUserId();
		String d = admincontroller.deleteCustomer(id);
		assertThat(d).isEqualTo("Account removed successfully!");
	}
	
	
	//test Merchant
	
	@Test
	@Rollback(true)
	public void testCreateMerchant() {
		MerchantDetails m = new MerchantDetails();
		m.setActive(true);
		m.setAlternateEmail("jackson_123@gmail.com");
		m.setAlternatePhoneNumber("8946454278");
		m.setApproved(true);
		m.seteMail("jackson@gmail.com");
		m.setName("Jackson Mills");
		m.setPassword("jackson*123");
		m.setPhoneNumber("7453749330");
		m.setRating(4);
		m.setRole("MERCHANT_ROLE");
		m.setSecurityAnswer("California");
		m.setSecurityQuestion("Birth Place");
		m.setUsername("Jack123");
		merchantRepository.save(m);
//		try {
//			ResponseEntity<?> m1 = admincontroller.registerMerchant(m);
//			assertThat(m1.getStatusCode()).isEqualTo(HttpStatus.OK);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		
	}
	
	@Test
	@Rollback(true)
	public void testGetMerchant() {
		MerchantDetails m = new MerchantDetails();
		m.setActive(true);
		m.setAlternateEmail("jackson_123@gmail.com");
		m.setAlternatePhoneNumber("8946454278");
		m.setApproved(true);
		m.seteMail("jackson@gmail.com");
		m.setName("Jackson Mills");
		m.setPassword("jackson*123");
		m.setPhoneNumber("7453749330");
		m.setRating(4);
		m.setRole("MERCHANT_ROLE");
		m.setSecurityAnswer("California");
		m.setSecurityQuestion("Birth Place");
		m.setUsername("Jack123");
		merchantRepository.save(m);
		int id = m.getUserId();
		assertThat(m).isEqualTo(admincontroller.getMerchant(id));
	}
	
	@Test
	@Rollback(true)
	public void updateMerchant() {
		MerchantDetails m = new MerchantDetails();
		m.setActive(true);
		m.setAlternateEmail("jackson_123@gmail.com");
		m.setAlternatePhoneNumber("8946454278");
		m.setApproved(true);
		m.seteMail("jackson@gmail.com");
		m.setName("Jackson Mills");
		m.setPassword("jackson*123");
		m.setPhoneNumber("7453749330");
		m.setRating(4);
		m.setRole("MERCHANT_ROLE");
		m.setSecurityAnswer("California");
		m.setSecurityQuestion("Birth Place");
		m.setUsername("Jack123");
		merchantRepository.save(m);
		m.setUsername("Jack_123");
		admincontroller.update(m);
		assertThat(m.getUsername()).isEqualTo("Jack_123");
	}
	
	
	//Test Product
	
	@Test
	@Rollback(true)
	public void testAddProduct() {
		Product p = new Product("Adidas Cosia", "shoes.jpg", 1783.0, 4, 5, "Adidas", 10, "white and blue sports shoes", 0,
				"Men's Fashion", true, true, true);
		productRepository.save(p);
		int p1 = admincontroller.addProduct(p);
		assertThat(p.getProductId()).isEqualTo(p1);
	}
	
	@Test
	@Rollback(true)
	public void TestUpdateProduct() {
		Product p = new Product("Adidas Cosia", "shoes.jpg", 1783.0, 4, 5, "Adidas", 10, "white and blue sports shoes", 0,
				"Men's Fashion", true, true, true);
		productRepository.save(p);
		p.setProductName("Adidas Cosia Adv");
		 admincontroller.update(p);
		assertThat(p.getProductName()).isEqualTo("Adidas Cosia Adv");
	}
	
	@Test
	@Rollback(true)
	public void TestDeleteProduct() {
		Product p = new Product("Adidas Cosia", "shoes.jpg", 1783.0, 4, 5, "Adidas", 10, "white and blue sports shoes", 0,
				"Men's Fashion", true, true, true);
		productRepository.save(p);
		boolean result = admincontroller.DeleteProduct(p.getProductId());
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	@Rollback(true)
	public void testgetAllProducts() {
		Product p = new Product("Adidas Cosia", "shoes.jpg", 1783.0, 4, 5, "Adidas", 10, "white and blue sports shoes", 0,
				"Men's Fashion", true, true, true);
		productRepository.save(p);
		assertNotNull(admincontroller.getAllProducts());
	}
	
	@Test
	@Rollback(true)
	public void testgetAllCoupons() {
		assertNotNull(admincontroller.getAllCoupons());
	}
	
	@Test
	@Rollback(true)
	public void testAddCoupon() {
		Coupon c = new Coupon();
		c.setCouponAmount(250);
		c.setCouponCode("NewUser123");
		c.setCouponEndDate(null);
		c.setCouponId(456);
		c.setCouponMinOrderAmount(1000);
		c.setCouponStartDate(null);
		c.setIssuedBy("Admin");
		c.setUseId(42729);
		couponRepo.save(c);
		try {
			ResponseEntity<Coupon> c1 = admincontroller.addCoupon(c);
			assertThat(c1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	@Rollback(true)
	public void testgetAllCommonFeedback() {
		assertNotNull(admincontroller.getAll());
	}
}
