package com.capstore.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.app.models.CustomerDetails;
import com.capstore.app.models.MerchantDetails;
import com.capstore.app.models.Product;
import com.capstore.app.models.ProductFeedback;
import com.capstore.app.models.User;
import com.capstore.app.Dao.AdminDao;
import com.capstore.app.Dao.AdminDaoImpl;
import com.capstore.app.repository.UserRepository;


@Transactional
@Service("AdminService")
public class AdminServiceImpl implements AdminServiceInteface{
	
	@Autowired
	private AdminDao admindao;
//	private AdminDaoImpl AdminComponent;

	@Override
	public void removeMerchantById(int userId) {
		// TODO Auto-generated method stub
		
		
		admindao.removeMerchantById(userId);
	}

	@Override
	public MerchantDetails addMerchant(MerchantDetails merchant) {
		// TODO Auto-generated method stub
		return admindao.addMerchant(merchant);
	}

	@Override
	public MerchantDetails findMerchantById(int userId) {
		// TODO Auto-generated method stub
		return admindao.findMerchantById(userId);
	}

	@Override
	public MerchantDetails findMerchantByName(String name) {
		// TODO Auto-generated method stub
		return admindao.findMerchantByName(name);
	}

	@Override
	public List<MerchantDetails> getAllMerchants() {
		// TODO Auto-generated method stub
		return admindao.getAllMerchants();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return admindao.getAllProducts();
	}

	@Override
	public Product getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return admindao.getProductByProductId(productId);
	}
	@Override
	public boolean removeProductbyId(int productId)
	{
		admindao.removeProductbyId(productId);
		return true;
	}

	@Override
	public List<Product> getProductsByCategory(String productCategory) {
		// TODO Auto-generated method stub
		return admindao.getProductsByCategory(productCategory);
	}

	@Override
	public List<Product> getProductsByBrand(String productBrand) {
		// TODO Auto-generated method stub
		return admindao.getProductsByBrand(productBrand);
	}

	@Override
	public List<Product> getProductsByType(String productInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getFeaturedProducts() {
		// TODO Auto-generated method stub
		return null;
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
	public List<CustomerDetails> getAllCustomers() {
		// TODO Auto-generated method stub
		
		List<CustomerDetails> customers= admindao.getAllCustomers();
		System.out.println(customers);
		return customers;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		 admindao.addUser(user) ;
		 return user;
	}

	@Override
	public void removeUserById(int userid) {
		// TODO Auto-generated method stub
		admindao.removeUserById(userid);
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return admindao.getAllUser();
	}

	@Override
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return admindao.getUserById(userid);
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
