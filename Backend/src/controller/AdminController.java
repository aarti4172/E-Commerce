package com.capstore.app.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.app.models.CustomerDetails;
import com.capstore.app.models.MerchantDetails;
import com.capstore.app.models.Product;
import com.capstore.app.service.AdminServiceInteface;



@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceInteface AdminService;
	
	private EmailService emailService;
	
	@RequestMapping(value="/hello")
	public String sayHello() {
		return "Hello World! from Capstore Spring Framework!";
	}
	
	//Add Customer
	@PostMapping("/customer")
	public CustomerDetails insertCustomer(@RequestBody CustomerDetails cust)
	{
		CustomerDetails cust1=AdminService.addCustomer(cust);
		return cust1;
		
	}
	//Get All Customers
	 @GetMapping("/customer")
	public ResponseEntity<List<CustomerDetails>> getAllCustomers()
	   {
			List<CustomerDetails> customers= AdminService.getAllCustomers();
			System.out.println("In Get All Customers");
			System.out.println(customers);
			if(customers.isEmpty()) {
				return new ResponseEntity("Sorry! No Customer Found!", HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<List<CustomerDetails>>(customers, HttpStatus.OK);
		}
	 
	 //Delete Customer
	 @DeleteMapping("/customer/{userId}")
		public  void deleteCustomer(@PathVariable("userId")int userId) 
	    {
			
		 AdminService.removeCustomerById(userId);
	//	 walletService.deleteCustomer(custId);
		
			
		}
	//Update Customer
	 
	 
	 //Add Merchant
	 @PostMapping("/merchant")
		public MerchantDetails addMerchant(@RequestBody MerchantDetails merchant)
		{
		 MerchantDetails merchant1=AdminService.addMerchant(merchant);
			return merchant1;
			
		}
	 
	 //Get All Merchant
	 @GetMapping("/merchant")
	 public ResponseEntity<List<MerchantDetails>> getAllMerchants(){
		List<MerchantDetails> merchants= AdminService.getAllMerchants();
			if(merchants.isEmpty()) {
			return new ResponseEntity("Sorry! No Merchant Found!", HttpStatus.NOT_FOUND);
		}
				
			return new ResponseEntity<List<MerchantDetails>>(merchants, HttpStatus.OK);		
		}
	 // Delete Merchant
	 
	 @DeleteMapping("/merchant/{MerchnatId}")
	public  Map<String, Boolean> deleteMerchant(@PathVariable("MerchnatId")int MerchnatId) 
	    {
			
		 
		 AdminService.removeMerchantById(MerchnatId);
		
		
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
	
	//sending invite to merchants
	@RequestMapping(value ="/invite",method = { RequestMethod.GET,RequestMethod.POST })
	public void invite(String email)
	{
		emailService.sendInvitationMail(email);
		
	}
	 //Get all Products
	 @RequestMapping("products")
		public List<Product> getAllProducts(){
		 List<Product> products=AdminService.getAllProducts();
			return products;
		}
	 @DeleteMapping("products/{ProductID}")
	 public boolean DeleteProduct(@PathVariable("ProductID")int productID)
	 {
		 return AdminService.removeProductbyId(productID);
	 }
	
	//add a new product
	@PostMapping("/addProduct")
	int addProduct(@RequestBody Product product) {
		product.setProductId((int)(Math.random()*100000));
		product.setDiscount(0);
		return AdminService.addProduct(product);
	}
	
	//get all the products
	@GetMapping("/getAllProducts")
	List<Product> getAllProducts(){
		return AdminService.getAllProducts();
	}
	
	//remove a product
	@DeleteMapping("/deleteProduct/{productId}")
	boolean removeProduct(@PathVariable int productId) {
		return AdminService.removeProduct(productId);
	}
	
	//get a product by product id
	@GetMapping("/getProductById/{productId}")
	Product getProductByProductId(@PathVariable int productId) {
		return AdminService.getProductByProductId(productId);
	}
	
	//update product
	@PutMapping("/updateProduct")
	boolean update(@RequestBody Product product) {
		return AdminService.update(product);
	}
	
	//update category by category
	@PutMapping("/updateByCategory")
	boolean updateCategoryByCategory(@RequestParam("productCategory")String productCategory, @RequestParam("updatedCategory")String updatedCategory) {
		return AdminService.updateCategoryByCategory(productCategory, updatedCategory);
	}
	
	//update category by Id
	@PutMapping("/updatedById")
	boolean updateCategoryById(@RequestParam("productId")Integer productId, @RequestParam("updatedCategory")String updatedCategory) {
		return AdminService.updateCategoryById(productId, updatedCategory);
	}
	
	 
}
