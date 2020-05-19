package com.capstore.app.Dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.capstore.app.models.CommonFeedback;
import com.capstore.app.models.CustomerDetails;
import com.capstore.app.models.MerchantDetails;
import com.capstore.app.models.Product;
import com.capstore.app.models.ProductFeedback;
import com.capstore.app.models.User;
import com.capstore.app.repository.CustomerRepository;
import com.capstore.app.repository.MerchantRepository;
import com.capstore.app.repository.ProductFeedbackRepository;
import com.capstore.app.repository.ProductRepository;
import com.capstore.app.repository.UserRepository;


@Component("AdminComponent")
public class AdminDaoImpl implements AdminDao{

	
	@Autowired
    private MerchantRepository merchantRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductFeedbackRepository productFeedbackRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	//Merchant
	@Override
	public void removeMerchantById(int userId) {
		
		merchantRepository.deleteById(userId);
		
	}

	@Override
	public MerchantDetails addMerchant(MerchantDetails merchant) {
		merchantRepository.save(merchant);
		return merchant;
	}

	@Override
	public MerchantDetails findMerchantById(int userId) {
		return merchantRepository.findById(userId).get();
	}

	@Override
	public MerchantDetails findMerchantByName(String name) {
		return null;
	}

	
	@Override
	public List<MerchantDetails> getAllMerchants() {
		return  merchantRepository.findAll();
	}

	
	//Product

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	

	@Override
	public Product getProductByProductId(int productId) {
		return productRepository.findById(productId).get();
	}
	@Override
	public boolean removeProductbyId(int productId)
	{
		 productRepository.deleteById(productId);
		return true;
	}
	@Override
	public List<Product> getProductsByCategory(String productCategory) {
		return productRepository.findByProductCategory(productCategory);
	}

	@Override
	public List<Product> getProductsByBrand(String productBrand) {
		return productRepository.findByProductBrand(productBrand);
	}

	@Override
	public List<Product> getProductsByType(String productInfo) {
		return productRepository.findByProductInfo(productInfo);
	}

	@Override
	public List<Product> getFeaturedProducts() {
		List<Product> products= getAllProducts();
		Iterator<Product> i = products.iterator();
		while(i.hasNext()) {
			Product pr= (Product)i.next();
			if(pr.isFeatured()==false) {
				i.remove();
			}
		}
		return products;
	}

	
	//Customer
	
	@Override
	public void removeCustomerById(int userId) {
	
		customerRepository.deleteById(userId);
	}

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		return customerRepository.save(customer);
		
	}

	@Override
	public CustomerDetails findCustomerById(int userId) {
		return customerRepository.findById(userId).get();
	}

	@Override
	public CustomerDetails findCustomerByName(String name) {
		return null;
	}

	
	@Override
	public List<CustomerDetails> getAllCustomers() {
		return customerRepository.findAll();
	}


	
	
//Product Feedback
	

	@Override
	public ProductFeedback addCommonFeedback(ProductFeedback pfd) {
		productFeedbackRepository.save(pfd);
		return pfd;
	}

	@Override
	public void removeProductFeedbackkById(int feedbackId) {
		productFeedbackRepository.deleteById(feedbackId);
		
	}

	@Override
	public void removeProductFeedbackByUserId(int userId) {
		productFeedbackRepository.deleteById(userId);
		
	}

//not working
    @Override
	public List<ProductFeedback> getAllProductFeedbackByUserId(int userId) {
		return null;
	}

	
	@Override
	public ProductFeedback getProductFeedbackById(int feedbackId) {
		return productFeedbackRepository.findById(feedbackId).get();
	}
//no logic:
	@Override
	public List<ProductFeedback> getProductFeedbackByProductId(int productId) {
	    
		return null;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		 userRepository.save(user);
		 return user;
	}

	@Override
	public void removeUserById(int userid) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userid);
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return userRepository.findById(userid).get();
	}

	
}