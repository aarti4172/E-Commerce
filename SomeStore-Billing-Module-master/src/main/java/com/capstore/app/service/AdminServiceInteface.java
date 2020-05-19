package com.capstore.app.service;
import java.util.List;

import com.capstore.app.models.CommonFeedback;
import com.capstore.app.models.CustomerDetails;
import com.capstore.app.models.MerchantDetails;
import com.capstore.app.models.Product;
import com.capstore.app.models.ProductFeedback;
import com.capstore.app.models.User;
import com.capstore.app.repository.UserRepository;

public interface AdminServiceInteface {





	
	//add,remove,view merchants using merchantrepository
	void removeMerchantById(int userId);
	MerchantDetails addMerchant(MerchantDetails merchant);
	MerchantDetails findMerchantById(int userId);
	MerchantDetails findMerchantByName(String name);
	List<MerchantDetails> getAllMerchants();//NotWorking
	
	
	//search, view using inventory repository9name, category, type
	
	List<Product> getAllProducts();
	
	Product getProductByProductId(int productId);
	List<Product> getProductsByCategory(String productCategory);
	boolean removeProductbyId(int productId);
	List<Product> getProductsByBrand(String productBrand);
	List<Product> getProductsByType(String productInfo);
	List<Product> getFeaturedProducts();
	
	
	//add, remove, view customers using customerrepository
	void removeCustomerById(int userId);
	CustomerDetails addCustomer(CustomerDetails customer);
	CustomerDetails findCustomerById(int userId);
	CustomerDetails findCustomerByName(String name);
	List<CustomerDetails> getAllCustomers();//NotWorking
	
	
	//User  Repository
	User addUser(User cfd);
	void removeUserById(int userid);
	List<User> getAllUser();//LogicNotWritten
	User getUserById(int userid);
	
	//Product feedbacks
	ProductFeedback addCommonFeedback(ProductFeedback cfd);
	void removeProductFeedbackkById(int feedbackId);
	void removeProductFeedbackByUserId(int userId);
	List<ProductFeedback> getAllProductFeedbackByUserId(int userId);//LogicNotWritten
	ProductFeedback getProductFeedbackById(int feedbackId);
	List<ProductFeedback> getProductFeedbackByProductId(int productId);
	
	
	
	
	
	//coupons , discounts, promos, 
	
	//customer validation 
	//email service
	
}