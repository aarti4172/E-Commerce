package com.example.main.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.exception.UserAlreadyExistsException;
import com.example.main.model.CommonFeedback;
import com.example.main.model.Coupon;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.User;
import com.example.main.service.AdminService;
import com.example.main.service.EmailService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController("AdminController")
@RequestMapping(value="/capstore/admin",method= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(AdminController.class);
	
		@Autowired
		private AdminService adminService;
		
		@Autowired
		private EmailService emailService;
		
		
		@RequestMapping(value="/hello")
		public String sayHello() {
			return "Hello World! from Capstore Spring Framework!";
		}
		
	
		//Customer:
		
		
		@GetMapping("/getAllCustomers")
		public ResponseEntity<List<CustomerDetails>> getAllCustomers()
		   {
			logger.trace("Get all customers working...");
				List<CustomerDetails> customers= adminService.getAllCustomers();
				System.out.println("In Get All Customers");
				System.out.println(customers);
				if(customers.isEmpty()) {
					return new ResponseEntity("Sorry! No Customer Found!", HttpStatus.NOT_FOUND);
				}
				
				return new ResponseEntity<List<CustomerDetails>>(customers, HttpStatus.OK);
			}
		  
		@DeleteMapping("/deleteCustomer/{userId}")//Not working --->delete cascaded ones first
		public  String deleteCustomer(@PathVariable("userId")int userId) {
			logger.trace("Delete Customer working...");
			 adminService.removeCustomerById(userId);
			 return "Account removed successfully!";
			}
		 
		 
		 
		 
		 
		 //merchant:
		 
		 @PostMapping(value = "/addMerchant")
			public ResponseEntity<MerchantDetails> createMerchant(@Valid @RequestBody MerchantDetails merchant) throws MailException, MessagingException, UnsupportedEncodingException, UserAlreadyExistsException {
			 logger.trace("Create Merchant working...");
				emailService.sendNotificationToMerchant(merchant);
				return new ResponseEntity<MerchantDetails>(HttpStatus.CREATED);
				   
			}
		 
		 @GetMapping("/verifyMerchant/{merchant}")//Not checked
			public ResponseEntity<MerchantDetails>verifyMerchantDetails(@PathVariable("merchant") String email){
			 logger.trace("Verify Merchant Details working...");
				return new ResponseEntity<MerchantDetails>(adminService.verifyMerchantDetails(email),HttpStatus.OK);
			}
		 
		 @PutMapping("/approveMerchant/{email}/{approved}")//Not checked
			public ResponseEntity<MerchantDetails> getApproval(@PathVariable("email") String email, @PathVariable("approved") boolean approved){
			 logger.trace("Get approval from admin working...");
			 	MerchantDetails merchant = adminService.getApproval(email, approved);
				if(merchant==null) {
					return new ResponseEntity("Sorry! Merchant not found!",HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<MerchantDetails>(merchant, HttpStatus.OK);
			}
		 

		@GetMapping(value = "/findMerchantById/{userId}")
		public MerchantDetails getMerchant(@PathVariable("userId")Integer userId) {
			logger.trace("Get Merchant by Id working...");
			return adminService.findMerchantById(userId);
			
		}
		
		
		 @GetMapping("/getAllMerchants")
		 public ResponseEntity<List<MerchantDetails>> getAllMerchants(){
			 logger.trace("Get all Merchants working...");
			List<MerchantDetails> merchants= adminService.getAllMerchant();
				if(merchants.isEmpty()) {
				return new ResponseEntity("Sorry! No Merchant Found!", HttpStatus.NOT_FOUND);
			}
					
				return new ResponseEntity<List<MerchantDetails>>(merchants, HttpStatus.OK);		
			}
		 
		@DeleteMapping("/deleteMerchant/{merchantId}")
		public  Map<String, Boolean> deleteMerchant(@PathVariable("merchantId")int merchantId) {
			logger.trace("Delete Merchant working...");
			 adminService.removeMerchantById(merchantId);
			 Map<String, Boolean> response = new HashMap<>();
			 response.put("deleted", Boolean.TRUE);
			 return response;
			}
		
		
		@RequestMapping(value ="/inviteUsers",method = { RequestMethod.GET,RequestMethod.POST })
		public void invite(User user){//Not written
			logger.trace("Invite Users working...");
		     emailService.sendInvitationsToUsers(user);	
		}
		
		@PutMapping(value="/updateMerchant")
		public boolean update(@RequestBody MerchantDetails merchant) {
			logger.trace("Update Merchant working...");
		     return adminService.updateMerchant(merchant);
		}
		
			
		//Product: 
		
		 @DeleteMapping("deleteProduct/{productID}")
		 public boolean DeleteProduct(@PathVariable("productID")int productID)
		 {
			 logger.trace("Delete Product working...");
			 return adminService.removeProduct(productID);
		 }
		
		@PostMapping("/addProduct")
		public Product addProduct(@RequestBody Product product) {
			logger.trace("Add Product working...");
			product.setProductId((int)(Math.random()*100000));
			product.setDiscount(0);
			return adminService.addProduct(product);
		}
		
		@GetMapping("/getAllProducts")
		List<Product> getAllProducts(){
			logger.trace("Get All Products working...");
			return adminService.getAllProducts();
		}
		
		@GetMapping("/getProductById/{productId}")
		Product getProductByProductId(@PathVariable int productId) {
			logger.trace("Get Product by Id working...");
			return adminService.getProductByProductId(productId);
		}
		
		@PutMapping("/updateProduct")
		boolean update(@RequestBody Product product) {
			logger.trace("Update Product working...");
			return adminService.update(product);
		}
		
		@PutMapping("/updateCategoryByCategory")
		boolean updateCategoryByCategory(@RequestParam("productCategory")String productCategory, @RequestParam("updatedCategory")String updatedCategory) {
			logger.trace("Update Category working...");
			return adminService.updateCategoryByCategory(productCategory, updatedCategory);
		}
		
			
	
		//Coupon
		
		@GetMapping("/getAllCoupons")
		public ResponseEntity<List<Coupon>>getAllAccounts(){
			logger.trace("Get All Coupons working...");
			return new ResponseEntity<List<Coupon>>(adminService.getCoupons(),HttpStatus.OK);
		}
		
		@PutMapping("/findCouponById/{couponId}")
		public ResponseEntity<Coupon> getAccountById(@PathVariable("couponId") int couponId) throws Exception{
			logger.trace("Get Coupon by Id working...");
			Coupon account= adminService.getCouponById(couponId).get();
			if(account==null) {
				return new ResponseEntity("Sorry! Coupon not found!",HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Coupon>(account, HttpStatus.OK);
		}
		
		@PutMapping("/findAccountByCouponCode/{couponCode}")
		public ResponseEntity<Coupon> getAccount(@PathVariable("couponCode") String couponCode){
			logger.trace("Get Coupon by Coupon Code working...");
			Coupon account= adminService.getCouponByCode(couponCode);
			if(account==null) {
				return new ResponseEntity("Sorry! Coupon not found!",HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Coupon>(account, HttpStatus.OK);
		}
		
		@PostMapping(value = "/addCoupon")
		public ResponseEntity<Coupon> addCoupon(@Valid @RequestBody Coupon coupon) {
			logger.trace("Add Coupon working...");
			adminService.addCoupon(coupon);
			return new ResponseEntity<Coupon>(HttpStatus.CREATED);
			   
		}
	
	
	
	
	//Common Feedback:
		
		@PutMapping(value="/forwardRequestToMerchant/{feedbackId}")
		public int forwardRequestToMerchant(@PathVariable int feedbackId) {
			logger.trace("Request forward to Merchant working...");
			return adminService.forwardRequestToMerchant(feedbackId);
		}
		
		@GetMapping(value="/forwardResponseToCustomer/{feedbackId}")
		public String forwardResponseToCustomer(@PathVariable int feedbackId) {
			logger.trace("Request forward to Customer working...");
			return adminService.forwardResponseToCustomer(feedbackId);
		}
		
		@GetMapping(value="/getAllCommonFeedbackByUserId/{userId}")
		public List<CommonFeedback> getAllCommonFeedbackByUserId(@PathVariable("userId") int userId) {
			logger.trace("Get all common feedback by user Id working...");
			return adminService.getAllCommonFeedbackByUserId(userId);
		}
		
		@GetMapping(value="/getCommonFeedbackById/{feedbackId}")
		public CommonFeedback getCommonFeedbackById(@PathVariable("feedbackId") int feedbackId) {
			logger.trace("Get Common Feedback by Id working...");
			return adminService.getCommonFeedbackById(feedbackId);
		}
		
		@GetMapping(value="/getAllCommonFeedbackByProductId/{productId}")
		public List<CommonFeedback> getAllCommonFeedbackByProductId(@PathVariable("productId") int productId) {
			logger.trace("Get All Common Feedback By Product Id working...");
			return adminService.getAllCommonFeedbackByProductId(productId);
		}
		
		@GetMapping(value="/getAllCommonFeedback")
		public List<CommonFeedback> getAll() {
			logger.trace("Get All Common Feedback working...");
			return adminService.getAll();
		}
		
	}
