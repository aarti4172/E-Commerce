package com.example.main.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.main.model.CommonFeedback;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.model.ProductFeedback;
import com.example.main.model.User;
import com.example.main.repository.CommonFeedbackRepository;
import com.example.main.repository.CustomerRepository;
import com.example.main.repository.MerchantRepository;
import com.example.main.repository.ProductFeedbackRepository;
import com.example.main.repository.ProductRepository;



@Component("AdminComponent")
public class AdminDaoImpl implements AdminDao{

	
	@Autowired
	@Qualifier(value="MerchantRepository")
	private MerchantRepository merchantRepository;
	@Autowired
	@Qualifier(value="CustomerRepository")
	private CustomerRepository customerRepository;
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
		return merchantRepository.findByName(name);
	}

	
	@Override
	public List<MerchantDetails> getAllMerchants() {
		return  merchantRepository.findAll();
	}

	@Override
	public int addProduct(Product product) {
		productRepository.save(product);
		return product.getProductId();
	}
	
	@Override
	public boolean removeProduct(int productId) {
		boolean exists = productRepository.existsById(productId);
		if(exists==true) {
		productRepository.deleteById(productId);
		return true;
		}
		else
			return false;
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductByProductId(int productId) {
		return productRepository.findById(productId).get();
	}
	
	@Override
	public boolean update(Product product) {
		boolean exists = productRepository.existsById(product.getProductId());
		if(exists==true) {
		Product p = productRepository.findById(product.getProductId()).get();
		p.setFeatured(product.isFeatured());
		if(product.getNoOfProducts()!=0)
		p.setNoOfProducts(product.getNoOfProducts());
		if(product.getNoOfProductViewed()!=0)
		p.setNoOfProductViewed(product.getNoOfProductViewed());
		p.setProductActivated(product.isProductActivated());
		if(product.getProductBrand()!=null)
		p.setProductBrand(product.getProductBrand());
		if(product.getProductCategory()!=null)
		p.setProductCategory(product.getProductCategory());
		if(product.getProductImage()!=null)
		p.setProductImage(product.getProductImage());
		if(product.getProductInfo()!=null)
		p.setProductInfo(product.getProductInfo());
		if(product.getProductName()!=null)
		p.setProductName(product.getProductName());
		if(product.getProductPrice()!=0)
		p.setProductPrice(product.getProductPrice());
		if(product.getProductRating()!=0)
		p.setProductRating(product.getProductRating());
		p.setStatus(product.isStatus());
		productRepository.save(p);
		return true;
		}
		return false;
	}

	@Override
	public boolean updateCategoryByCategory(String productCategory, String updatedCategory) {
		List<Product> products = productRepository.findAllByProductCategory(productCategory);
		Iterator<Product> i = products.iterator();
		while(i.hasNext()) {
			Product pr= (Product)i.next();
			pr.setProductCategory(updatedCategory);
		}
		productRepository.saveAll(products);
		return true;
	}

	@Override
	public boolean updateCategoryById(int productId, String updatedCategory) {
		Product p = productRepository.findById(productId).get();
		p.setProductCategory(updatedCategory);
		productRepository.save(p);
		return true;
	}

	
	@Override
	public void removeCustomerById(int userId) {
		customerRepository.deleteById(userId);
	}

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public CustomerDetails findCustomerById(int userId) {
		return customerRepository.findById(userId).get();
	}

	@Override
	public CustomerDetails findCustomerByName(String name) {
		return customerRepository.findByName(name);
	}

	
	@Override
	public List<CustomerDetails> getAllCustomers() {
		return customerRepository.findAll();
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

	//not working------
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

}

