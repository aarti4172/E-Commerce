package com.capgemini.admin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admin.dao.AdminDao;
import com.capgemini.admin.dao.MerchantRepository;
import com.capgemini.admin.entity.CommonFeedback;
import com.capgemini.admin.entity.CustomerDetails;
import com.capgemini.admin.entity.MerchantDetails;
import com.capgemini.admin.entity.Product;
import com.capgemini.admin.entity.ProductFeedback;
import com.capgemini.admin.entity.User;


@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	
	
	
	private AdminDao admindao;
	
	
	@Override
	public void addMerchant(MerchantDetails m) {
		// TODO Auto-generated method stub
		//merchantRepo.save(m);
		admindao.addMerchant(m);
		
	}

	@Override
	public void removeMerchant(Integer id) {
		// TODO Auto-generated method stub
		admindao.removeMerchantById(id);
		//merchantRepo.delete(m);
	}

	@Override
	public List<MerchantDetails> getAllMerchant() {
		// TODO Auto-generated method stub
		return admindao.getAllMerchants();
		//return merchantRepo.findAll();
	}

	@Override
	public void updateMerchant(MerchantDetails m) {
		// TODO Auto-generated method stub
		//merchantRepo.save(m);
		
	}

	@Override
	public MerchantDetails findMerchantById(Integer id) {
		return admindao.findMerchantById(id);
	}

	@Override
	public int addProduct(Product product) {
		return admindao.addProduct(product);
	}

	@Override
	public boolean removeProduct(int productId) {
		return admindao.removeProduct(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return admindao.getAllProducts();
	}

	@Override
	public Product getProductByProductId(int productId) {
		return admindao.getProductByProductId(productId);
	}

	@Override
	public boolean update(Product product) {
		return admindao.update(product);
	}

	@Override
	public boolean updateCategoryByCategory(String productCategory, String updatedCategory) {
		return admindao.updateCategoryByCategory(productCategory, updatedCategory);
	}

	@Override
	public boolean updateCategoryById(int productId, String updatedCategory) {
		return admindao.updateCategoryById(productId, updatedCategory);
	}

	@Override
	public void removeCustomerById(int userId) {
		// TODO Auto-generated method stub
		admindao.removeCustomerById(userId);
	}

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		// TODO Auto-generated method stub
		return admindao.addCustomer(customer);
	}

	@Override
	public CustomerDetails findCustomerById(int userId) {
		// TODO Auto-generated method stub
		return admindao.findCustomerById(userId);
	}

	@Override
	public CustomerDetails findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return admindao.getAllCustomers();
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

}
