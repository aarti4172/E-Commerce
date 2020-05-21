package com.example.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.dao.AdminDao;
import com.example.main.model.CommonFeedback;
import com.example.main.model.Coupon;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.ProductFeedback;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	
	
	@Autowired
	private AdminDao adminDao;
	
	
	

	//Merchant: 
	@Override
	public MerchantDetails addMerchant(MerchantDetails m) {
		return adminDao.addMerchant(m);
		
	}

	@Override
	public void removeMerchantById(int merchantId) {
		adminDao.removeMerchantById(merchantId);
	}
	

	@Override
	public List<MerchantDetails> getAllMerchant() {
		List<MerchantDetails> merchants=new ArrayList<MerchantDetails>();
		adminDao.findAllMerchants().forEach(merchants::add);
		return merchants;
	}

	@Override
	public boolean updateMerchant(MerchantDetails updatedMerchant) {
		return adminDao.updateMerchant(updatedMerchant);
	}

	@Override
	public MerchantDetails findMerchantById(int userId) {
		return adminDao.findMerchantById(userId);
	}
	
    
	
	public MerchantDetails verifyMerchantDetails(String email) {
		return adminDao.findMerchantByeMail(email);
	}


	public MerchantDetails getApproval(String email, boolean approved) {
		MerchantDetails merchant = adminDao.findMerchantByeMail(email);
		merchant.setApproved(approved);
		adminDao.addMerchant(merchant);
		return merchant;
	}
	
	
	public List<MerchantDetails> getMerchants() {
		List<MerchantDetails> merchant = new ArrayList<>();
		adminDao.findAllMerchants().forEach(merchant::add);
		return merchant;
	}

	
	
	//Product:
	@Override
	public Product addProduct(Product product) {
		return adminDao.addProduct(product);
	}

	@Override
	public boolean removeProduct(int productId) {
		return adminDao.removeProduct(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return adminDao.getAllProducts();
	}

	@Override
	public Product getProductByProductId(int productId) {
		return adminDao.getProductByProductId(productId);
	}

	@Override
	public boolean update(Product product) {
		return adminDao.update(product);
	}

	@Override
	public boolean updateCategoryByCategory(String productCategory, String updatedCategory) {
		return adminDao.updateCategoryByCategory(productCategory, updatedCategory);
	}

	@Override
	public boolean updateCategoryById(int productId, String updatedCategory) {
		return adminDao.updateCategoryById(productId, updatedCategory);
	}
	
	
	
	//Customer:

	@Override
	public void removeCustomerById(int userId) {
		// TODO Auto-generated method stub
		adminDao.removeCustomerById(userId);
	}


	@Override
	public CustomerDetails findCustomerById(int userId) {
		// TODO Auto-generated method stub
		return adminDao.findCustomerById(userId);
	}

	@Override
	public CustomerDetails findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return adminDao.findCustomerByName(name);
	}

	@Override
	public List<CustomerDetails> getAllCustomers() {
		// TODO Auto-generated method stub
		return adminDao.getAllCustomers();
	}

	@Override
	public CommonFeedback addCommonFeedback(CommonFeedback cfd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCommonFeedbackById(int feedbackId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCommonFeedbackByUserId(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommonFeedback> getAllCommonFeedbackByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonFeedback getCommonFeedbackById(int feedbackId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductFeedback addCommonFeedback(ProductFeedback cfd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProductFeedbackkById(int feedbackId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProductFeedbackByUserId(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductFeedback> getAllProductFeedbackByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductFeedback getProductFeedbackById(int feedbackId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductFeedback> getProductFeedbackByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	//Coupon:
	public void addCoupon(Coupon coupon) {
		adminDao.addCoupon(coupon);
	}
	
	public List<Coupon> getCoupons() {
		List<Coupon> coupon = new ArrayList<>();
		adminDao.findAllCoupons().forEach(coupon::add);
		return coupon;
	}
	
	public Coupon getCouponByCode(String code) { 
	 Coupon coupon = adminDao.findByCouponCode(code);
     return coupon;
	}

	public Optional<Coupon> getCouponById(int couponId) throws Exception {
		Coupon coupon = adminDao.findById(couponId)
				.orElseThrow(() -> new Exception("Account Holder not found for this id : " + couponId));
	    return Optional.of(coupon);
	}

	

	

}