package com.example.main.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.main.model.CommonFeedback;
import com.example.main.model.Coupon;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.ProductFeedback;

public interface AdminService {

	//Merchant
	public MerchantDetails addMerchant(MerchantDetails m);
	public void removeMerchantById(int merchantId);
	public List<MerchantDetails> getAllMerchant();
	public boolean updateMerchant(MerchantDetails m);
	public MerchantDetails findMerchantById(int userId);
	public MerchantDetails verifyMerchantDetails(String email);
	public MerchantDetails getApproval(String email, boolean approved);
	
	//Products
	Product addProduct(Product product);
	boolean removeProduct(int productId);
	List<Product> getAllProducts();
	Product getProductByProductId(int productId);
	boolean update(Product product);
	boolean updateCategoryByCategory(String productCategory, String UpdatedCategory);
	boolean updateCategoryById(int productId, String updatedCategory);
	
	
	//Customer
	void removeCustomerById(int userId);
	CustomerDetails findCustomerById(int userId);
	CustomerDetails findCustomerByName(String name);
	List<CustomerDetails> getAllCustomers();
	
	
	//Common feedbacks
	List<CommonFeedback> getAllCommonFeedbackByProductId(int productId);
	CommonFeedback getCommonFeedbackById(int feedbackId);
	List<CommonFeedback> getAllCommonFeedbackByUserId(int userId);
	int forwardRequestToMerchant(int feedbackId);
	String forwardResponseToCustomer(int feedbackId);
	List<CommonFeedback> getAll();
	
	
	//Product feedbacks
	ProductFeedback addCommonFeedback(ProductFeedback pfd);
	void removeProductFeedbackkById(int feedbackId);
	void removeProductFeedbackByUserId(int userId);
	List<ProductFeedback> getAllProductFeedbackByUserId(int userId);//LogicNotWritten
	ProductFeedback getProductFeedbackById(int feedbackId);
	List<ProductFeedback> getProductFeedbackByProductId(int productId);
	
	
	
	//Coupon:
	public List<Coupon> getCoupons();
	public Optional<Coupon> getCouponById(int couponId) throws Exception;
	public Coupon getCouponByCode(String couponCode);
	public void addCoupon(@Valid Coupon coupon);
	
	
	
	
	
	
}
