package com.example.main.dao;

import java.util.List;

import com.example.main.model.CommonFeedback;
import com.example.main.model.CustomerDetails;
import com.example.main.model.Inventory;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.ProductFeedback;
import com.example.main.model.User;

public interface AdminDao {
	
	//add,remove,view merchants using merchantrepository
	void removeMerchantById(int userId);
	MerchantDetails addMerchant(MerchantDetails merchant);
	MerchantDetails findMerchantById(int userId);
	MerchantDetails findMerchantByName(String name);
	List<MerchantDetails> getAllMerchants();//NotWorking
	
	
	//search, view using inventory repository9name, category, type
	List<Inventory> getAllInventories();
	List<Product> getAllProducts();
	List<Product> getProductsbyInventoryId(int invertoryId);
	Product getProductByProductId(int productId);
	List<Product> getProductsByCategory(String productCategory);
	List<Product> getProductsByBrand(String productBrand);
	List<Product> getProductsByType(String productInfo);
	List<Product> getFeaturedProducts();
	
	
	//add, remove, view customers using customerrepository
	void removeCustomerById(int userId);
	CustomerDetails addCustomer(CustomerDetails customer);
	CustomerDetails findCustomerById(int userId);
	CustomerDetails findCustomerByName(String name);
	List<CustomerDetails> getAllCustomers();//NotWorking
	
	
	//Common feedbacks
	CommonFeedback addCommonFeedback(CommonFeedback cfd);
	void removeCommonFeedbackById(int feedbackId);
	void removeCommonFeedbackByUserId(int userId);
	List<CommonFeedback> getAllCommonFeedbackByUserId(int userId);//LogicNotWritten
	CommonFeedback getCommonFeedbackById(int feedbackId);
	
	
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
