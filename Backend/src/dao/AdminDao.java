package com.example.main.dao;

import java.util.List;

import com.example.main.model.CommonFeedback;
import com.example.main.model.CustomerDetails;
import com.example.main.model.Inventory;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.ProductFeedback;

public interface AdminDao {
	
	//add,remove,view merchants using merchantrepository
	void removeMerchant(MerchantDetails merchant);
	MerchantDetails addMerchant(MerchantDetails merchant);
	MerchantDetails findMerchantById(int userId);
	MerchantDetails findMerchantByName(String name);
	List<MerchantDetails> getAllMerchants();
	
	
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
	void removeCustomer(CustomerDetails customer);
	CustomerDetails addCustomer(CustomerDetails customer);
	CustomerDetails findCustomerById(int userId);
	CustomerDetails findCustomerByName(String name);
	List<CustomerDetails> getAllCustomers();
	
	
	//Common feedbacks
	CommonFeedback addCommonFeedback(CommonFeedback cfd);
	void removeCommonFeedbackById(int feedbackId);
	void removeCommonFeedbackByUserId(int userId);
	List<CommonFeedback> getAllCommonFeedbackByUserId(int userId);
	CommonFeedback getCommonFeedbackById(int feedbackId);
	
	
	//Product feedbacks
	ProductFeedback addCommonFeedback(ProductFeedback cfd);
	void removeProductFeedbackkById(int feedbackId);
	void removeProductFeedbackByUserId(int userId);
	List<ProductFeedback> getAllProductFeedbackByUserId(int userId);
	ProductFeedback getProductFeedbackById(int feedbackId);
	List<ProductFeedback> getProductFeedbackByProductId(int productId);
	
	
	//coupons , discounts, promos, 
	
	//customer validation 
	//email service
	
}
