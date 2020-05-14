package com.example.main.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.main.model.CommonFeedback;
import com.example.main.model.CustomerDetails;
import com.example.main.model.Inventory;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.ProductFeedback;
import com.example.main.model.User;
import com.example.main.repository.CommonFeedbackRepository;
import com.example.main.repository.InventoryRepository;
import com.example.main.repository.ProductFeedbackRepository;
import com.example.main.repository.ProductRepository;
//import com.example.main.repository.MerchantRepository;
import com.example.main.repository.UserRepository;


@Component("AdminComponent")
public class AdminDaoImpl implements AdminDao{

	/*
	@Autowired
	@Qualifier(value="MerchantRepository")
	private MerchantRepository merchantRepository;
	*/
	@Autowired
	@Qualifier(value="UserRepository")
	private UserRepository userRepository;
	@Autowired
	@Qualifier(value="InventoryRepository")
	private InventoryRepository inventoryRepository;
	@Autowired
	@Qualifier(value="ProductRepository")
	private ProductRepository productRepository;
	@Autowired
	@Qualifier(value="ProductFeedbackRepository")
	private ProductFeedbackRepository productFeedbackRepository;
	@Qualifier(value="CommonFeedbackRepository")
	private CommonFeedbackRepository commonFeedbackRepository;
	
	
	@Override
	public void removeMerchantById(int userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public MerchantDetails addMerchant(MerchantDetails merchant) {
		userRepository.save(merchant);
		return merchant;
	}

	@Override
	public MerchantDetails findMerchantById(int userId) {
		return (MerchantDetails) userRepository.findById(userId).get();
	}

	@Override
	public MerchantDetails findMerchantByName(String name) {
		return (MerchantDetails) userRepository.findByName(name);
	}

	//Not working. Using findAll() will call both customers and merchants. But we want the list of merchants only
	//One possible solution-> create separate repositories for merchant as well as customers
	@Override
	public List<MerchantDetails> getAllMerchants() {
		return  null;
	}

	@Override
	public List<Inventory> getAllInventories() {
		return inventoryRepository.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductsbyInventoryId(int invertoryId) {
		return productRepository.findByInventoryId();
	}

	@Override
	public Product getProductByProductId(int productId) {
		return productRepository.findByProductId();
	}

	@Override
	public List<Product> getProductsByCategory(String productCategory) {
		return productRepository.findByProductCategory();
	}

	@Override
	public List<Product> getProductsByBrand(String productBrand) {
		return productRepository.findByProductBrand();
	}

	@Override
	public List<Product> getProductsByType(String productInfo) {
		return productRepository.findByProductInfo();
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

	
	@Override
	public void removeCustomerById(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		userRepository.save(customer);
		return customer;
	}

	@Override
	public CustomerDetails findCustomerById(int userId) {
		return (CustomerDetails) userRepository.findById(userId).get();
	}

	@Override
	public CustomerDetails findCustomerByName(String name) {
		return (CustomerDetails) userRepository.findByName(name);
	}

	// Not working:------> Same problem as with the Merchant class. Using findAll() will call both customers and merchants.
	//But we want the list of customers only
	@Override
	public List<CustomerDetails> getAllCustomers() {
		return null;
	}


	@Override
	public CommonFeedback addCommonFeedback(CommonFeedback cfd) {
		commonFeedbackRepository.save(cfd);
		return cfd;
	}

	@Override
	public void removeCommonFeedbackById(int feedbackId) {
		commonFeedbackRepository.deleteById(feedbackId);
		
	}

	@Override
	public void removeCommonFeedbackByUserId(int userId) {
		commonFeedbackRepository.deleteByUserId(userId);
		
	}

	//Logic not written: 
	@Override
	public List<CommonFeedback> getAllCommonFeedbackByUserId(int userId) {
		return null;
	}
	

	@Override
	public CommonFeedback getCommonFeedbackById(int feedbackId) {
		return commonFeedbackRepository.findById(feedbackId).get();
	}

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
		productFeedbackRepository.deleteByUserId(userId);
		
	}


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

}
