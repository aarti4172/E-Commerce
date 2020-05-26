package com.example.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.dao.AdminDao;
import com.example.main.dao.AdminDaoImpl;
import com.example.main.model.CommonFeedback;
import com.example.main.model.Coupon;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.ProductFeedback;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	org.slf4j.Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao adminDao;
	
	
	

	//Merchant: 
	@Override
	public MerchantDetails addMerchant(MerchantDetails m) {
		logger.trace("Add Merchant working...");
		return adminDao.addMerchant(m);
		
	}

	@Override
	public void removeMerchantById(int merchantId) {
		logger.trace("Delete Merchant working...");
		adminDao.removeMerchantById(merchantId);
	}
	

	@Override
	public List<MerchantDetails> getAllMerchant() {
		logger.trace("Get All Merchants working...");
		List<MerchantDetails> merchants=new ArrayList<MerchantDetails>();
		adminDao.findAllMerchants().forEach(merchants::add);
		return merchants;
	}

	@Override
	public boolean updateMerchant(MerchantDetails updatedMerchant) {
		logger.trace("Update Merchant working...");
		return adminDao.updateMerchant(updatedMerchant);
	}

	@Override
	public MerchantDetails findMerchantById(int userId) {
		logger.trace("Find Merchant By Id working...");
		return adminDao.findMerchantById(userId);
	}
	
    
	
	public MerchantDetails verifyMerchantDetails(String email) {
		logger.trace("Verify Merchant working...");
		return adminDao.findMerchantByeMail(email);
	}


	public MerchantDetails getApproval(String email, boolean approved) {
		logger.trace("Get Approval working...");
		MerchantDetails merchant = adminDao.findMerchantByeMail(email);
		merchant.setApproved(approved);
		adminDao.addMerchant(merchant);
		return merchant;
	}
	
	
	public List<MerchantDetails> getMerchants() {
		logger.trace("Get Merchants working...");
		List<MerchantDetails> merchant = new ArrayList<>();
		adminDao.findAllMerchants().forEach(merchant::add);
		return merchant;
	}

	
	
	//Product:
	@Override
	public Product addProduct(Product product) {
		logger.trace("Add Product working...");
		return adminDao.addProduct(product);
	}

	@Override
	public boolean removeProduct(int productId) {
		logger.trace("Delete Product working...");
		return adminDao.removeProduct(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		logger.trace("Get All Products working...");
		return adminDao.getAllProducts();
	}

	@Override
	public Product getProductByProductId(int productId) {
		logger.trace("Get Product By Id working...");
		return adminDao.getProductByProductId(productId);
	}

	@Override
	public boolean update(Product product) {
		logger.trace("Update Product working...");
		return adminDao.update(product);
	}

	@Override
	public boolean updateCategoryByCategory(String productCategory, String updatedCategory) {
		logger.trace("Update Category working...");
		return adminDao.updateCategoryByCategory(productCategory, updatedCategory);
	}
	
	
	//Customer:

	@Override
	public void removeCustomerById(int userId) {
		logger.trace("Delete Customer working...");
		adminDao.removeCustomerById(userId);
	}


	@Override
	public CustomerDetails findCustomerById(int userId) {
		logger.trace("Find Customer By Id working...");
		return adminDao.findCustomerById(userId);
	}

	@Override
	public CustomerDetails findCustomerByName(String name) {
		logger.trace("Find Customer By Name working...");
		return adminDao.findCustomerByName(name);
	}

	@Override
	public List<CustomerDetails> getAllCustomers() {
		logger.trace("Get All Customers working...");
		return adminDao.getAllCustomers();
	}

	
	
	
	
	//CommonFeedback:
	
	
	@Override
	public List<CommonFeedback> getAllCommonFeedbackByUserId(int userId) {
		logger.trace("Get All Common Feedback By User Id working...");
		return adminDao.getAllCommonFeedbackByUserId(userId);
	}

	@Override
	public CommonFeedback getCommonFeedbackById(int feedbackId) {
		logger.trace("Get Common Feedback by Id working...");
		return adminDao.getCommonFeedbackById(feedbackId);
	}
	
	@Override
	public List<CommonFeedback> getAllCommonFeedbackByProductId(int productId) {
		logger.trace("Get All Common Feedback by Product Id working...");
		return adminDao.getAllCommonFeedbackByProductId(productId);
	}

	@Override
	public int forwardRequestToMerchant(int feedbackId) {
		logger.trace("Request To Merchant working...");
		return adminDao.forwardRequestToMerchant(feedbackId);
	}

	@Override
	public String forwardResponseToCustomer(int feedbackId) {
		logger.trace("Response to Customer working...");
		return adminDao.forwardResponseToCustomer(feedbackId);
	}
	
	@Override
	public List<CommonFeedback> getAll() {
		logger.trace("Get All Common Feedback working...");
		return adminDao.getAll();
	}

	//ProductFeedback:
	

	@Override
	public void removeProductFeedbackkById(int feedbackId) {
		logger.trace("Delete Product Feedback working...");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProductFeedbackByUserId(int userId) {
		logger.trace("Delete Product Feedback working...");
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductFeedback> getAllProductFeedbackByUserId(int userId) {
		logger.trace("Get All Product Feedback by User Id working...");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductFeedback getProductFeedbackById(int feedbackId) {
		logger.trace("Get Product Feedback By Id working...");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductFeedback> getProductFeedbackByProductId(int productId) {
		logger.trace("Get Product Feedback working...");
		// TODO Auto-generated method stub
		return null;
	}
	
	//Coupon:
	public void addCoupon(Coupon coupon) {
		logger.trace("Add Coupon working...");
		adminDao.addCoupon(coupon);
	}
	
	public List<Coupon> getCoupons() {
		logger.trace("Get Coupon working...");
		List<Coupon> coupon = new ArrayList<>();
		adminDao.findAllCoupons().forEach(coupon::add);
		return coupon;
	}
	
	public Coupon getCouponByCode(String code) { 
		logger.trace("Get Coupon By Code working...");
	 Coupon coupon = adminDao.findByCouponCode(code);
     return coupon;
	}

	public Optional<Coupon> getCouponById(int couponId) throws Exception {
		logger.trace("Get Coupon By Id working...");
		Coupon coupon = adminDao.findById(couponId)
				.orElseThrow(() -> new Exception("Account Holder not found for this id : " + couponId));
	    return Optional.of(coupon);
	}

	@Override
	public ProductFeedback addCommonFeedback(ProductFeedback pfd) {
		logger.trace("Add Common Feedback working...");
		// TODO Auto-generated method stub
		return null;
	}

}
