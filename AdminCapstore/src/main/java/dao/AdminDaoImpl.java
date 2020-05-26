package com.example.main.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.main.model.CommonFeedback;
import com.example.main.model.Coupon;
import com.example.main.model.CustomerDetails;
import com.example.main.model.MerchantDetails;
import com.example.main.model.Product;
import com.example.main.repository.CommonFeedbackRepository;
import com.example.main.repository.CouponRepository;
import com.example.main.repository.CustomerRepository;
import com.example.main.repository.MerchantRepository;
import com.example.main.repository.ProductFeedbackRepository;
import com.example.main.repository.ProductRepository;

@Component("AdminComponent")
public class AdminDaoImpl implements AdminDao{
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	
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
	
	@Autowired
	@Qualifier(value="CommonFeedbackRepository")
	private CommonFeedbackRepository commonFeedbackRepository;
	
	@Autowired
	@Qualifier(value="CouponRepository")
	private CouponRepository couponRepository;
		
	
	//Merchant:
	
	@Override
	public void removeMerchantById(int userId) {
		logger.trace("Delete Merchant working...");
		merchantRepository.deleteById(userId);
		
	}

	@Override
	public MerchantDetails addMerchant(MerchantDetails merchant) {
		logger.trace("Add Merchant working...");
		merchantRepository.save(merchant);
		return merchant;
	}

	@Override
	public MerchantDetails findMerchantById(int userId) {
		logger.trace("Find Merchant by Id working...");
		return merchantRepository.findById(userId).get();
	}

	@Override
	public MerchantDetails findMerchantByeMail(String eMail) {
		logger.trace("Find Merchant by Email working...");
		return merchantRepository.findByeMail(eMail);
	}
	
	@Override
	public Iterable<MerchantDetails> findAllMerchants() {
		logger.trace("Find All Merchants working...");
		return  merchantRepository.findAll();
	}
	
	@Override
	public boolean updateMerchant(MerchantDetails updatedMerchant) {
		logger.trace("Update Merchant working...");
		boolean exists = merchantRepository.existsById(updatedMerchant.getUserId());
		if(exists==true) {
		MerchantDetails merchant = findMerchantById(updatedMerchant.getUserId());
		if(updatedMerchant.getPhoneNumber()!=null)
			merchant.setPhoneNumber(updatedMerchant.getPhoneNumber());
		if(updatedMerchant.getAlternatePhoneNumber()!=null)
			merchant.setAlternatePhoneNumber(updatedMerchant.getAlternatePhoneNumber());
		if(updatedMerchant.getAddresses()!=null)
			merchant.setAddresses(updatedMerchant.getAddresses());
		if(updatedMerchant.getAlternateEmail()!=null)
			merchant.setAlternateEmail(updatedMerchant.getAlternateEmail());
		if(updatedMerchant.getName()!=null)
			merchant.setName(updatedMerchant.getName());
		merchantRepository.save(merchant);
		return true;
		}
		return false;
	}
		

	//Product
	
	@Override
	public Product addProduct(Product product) {
		logger.trace("Add Product working...");
		productRepository.save(product);
		return product;
	}
	
	@Override
	public boolean removeProduct(int productId) {
		logger.trace("Delete Product working...");
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
		logger.trace("Get All Products working...");
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductByProductId(int productId) {
		logger.trace("Find Product by Id working...");
		return productRepository.findById(productId).get();
	}
	
	@Override
	public boolean update(Product product) {
		logger.trace("Update Product working...");
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

	/**
	 * Changes the name of a category. All the products having that category gets changed to another category
	*/
	@Override
	public boolean updateCategoryByCategory(String productCategory, String updatedCategory) {
		logger.trace("Update Category working...");
		List<Product> products = productRepository.findAllByProductCategory(productCategory);
		Iterator<Product> i = products.iterator();
		while(i.hasNext()) {
			Product pr= (Product)i.next();
			pr.setProductCategory(updatedCategory);
		}
		productRepository.saveAll(products);
		return true;
	}

	
	//Customer
	
	@Override
	public void removeCustomerById(int userId) {
		logger.trace("Delete Customer working...");
		customerRepository.deleteById(userId);
	}


	@Override
	public CustomerDetails findCustomerById(int userId) {
		logger.trace("Find  Customer By Id working...");
		return customerRepository.findById(userId).get();
	}

	@Override
	public CustomerDetails findCustomerByName(String name) {
		logger.trace("Find Customer by Name working...");
		return customerRepository.findByName(name);
	}
	
	@Override
	public CustomerDetails findCustomerByEMailIgnoreCase(String eMail) {
		logger.trace("Find Customer by Email working...");
		return customerRepository.findByeMail(eMail);
	}

	
	@Override
	public List<CustomerDetails> getAllCustomers() {
		logger.trace("Get all customers working...");
		return customerRepository.findAll();
	}
	
	@Override
	public boolean existingCustomerByEmail(String eMail) {
		logger.trace("Customer Exists working...");
		boolean result = false;
		if (customerRepository.existsByeMail(eMail)){
			result=  true;
		}
		return result;
	}

	//Common Feedback
		
	@Override
	public List<CommonFeedback> getAllCommonFeedbackByProductId(int productId) {
		logger.trace("Get All Common Feedbacks By Product Id working...");
		return commonFeedbackRepository.findAllByProductId(productId);
	}
	

	@Override
	public CommonFeedback getCommonFeedbackById(int feedbackId) {
		logger.trace("Get Common Feedback By Id working...");
		return commonFeedbackRepository.findById(feedbackId).get();
	}
	
	@Override
	public List<CommonFeedback> getAllCommonFeedbackByUserId(int userId) {
		logger.trace("Get all Common Feedback by User Id working...");
		return commonFeedbackRepository.findAllByUserId(userId);
	}

	@Override
	public int forwardRequestToMerchant(int feedbackId) {
		logger.trace("Request to Merchant working...");
		int merchantId = 0;
		CommonFeedback cfd =  getCommonFeedbackById(feedbackId);
		if(cfd.isRequestFlag()== true) {
			cfd.setRequestApproved(true);
			//Product product= productRepository.findByProductId(cfd.getProductId());
			merchantId = productRepository.findMerchantId(cfd.getProductId());
			//merchantId = product.getProductMerchantId();
		}
		return merchantId;
	}

	@Override
	public String forwardResponseToCustomer(int feedbackId) {
		logger.trace("Request To Customner working...");
		CommonFeedback cfd =  getCommonFeedbackById(feedbackId);
		if(cfd.isResponseFlag() == true) {
			cfd.setResponseApproved(true);
		}
		return cfd.getResponseMessage();
	}
	
	@Override
	public List<CommonFeedback> getAll() {
		logger.trace("Get All Customers working...");
		return commonFeedbackRepository.findAll();
	}

	//Coupons:
	@Override
	public Coupon addCoupon(Coupon coupon) {
		logger.trace("Add Coupon working...");
		return couponRepository.save(coupon);
		
	}

	@Override
	public Optional<Coupon> findById(int couponId) {
		logger.trace("Find By Id working...");
		return couponRepository.findById(couponId);
	}

	@Override
	public Iterable<Coupon> findAllCoupons() {
		logger.trace("Find All Coupons working...");
		return couponRepository.findAll();
	}

	@Override
	public Coupon findByCouponCode(String couponCode) {
		logger.trace("Find Coupon by Code working...");
		return couponRepository.findByCouponCode(couponCode);
	}

	
}
