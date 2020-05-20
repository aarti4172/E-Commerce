package com.store.service;

import java.util.List;

import com.capgemini.entity.MerchantDetails;


public interface AdminService {

	
	public void addMerchant(MerchantDetails m);
	public void removeMerchant(Integer id);
	public List<MerchantDetails> getAllMerchant();
	public void updateMerchant(MerchantDetails m);
	public MerchantDetails findMerchantById(Integer id);
	
	//Managing Full Inventory/ all Products
	int addProduct(Product product);
	boolean removeProduct(int productId);
	List<Product> getAllProducts();
	Product getProductByProductId(int productId);
	boolean update(Product product);
	boolean updateCategoryByCategory(String productCategory, String UpdatedCategory);
	boolean updateCategoryById(int productId, String updatedCategory);
	
	
	//add, remove, view customers using customerrepository
	void removeCustomerById(int userId);
	CustomerDetails addCustomer(CustomerDetails customer);
	CustomerDetails findCustomerById(int userId);
	CustomerDetails findCustomerByName(String name);
	List<User> getAllCustomers();//NotWorking
	
	
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
	
	
	
}

