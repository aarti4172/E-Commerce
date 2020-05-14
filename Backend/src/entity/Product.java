package com.store.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="product_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String productImage;
	private double productPrice;
	private int productRating;
	private int noOfProductsViewed;
	private String productBrand;
	private int noOfProducts;
	private String productInfo;
	private String productCategory;
	private double productDiscount;
	private boolean productActivated;
	private boolean status;
	private boolean featured;
	private int productMerchantId;
	Set<ProductFeedBack> feedbacks;
	
	public Product() {
		feedbacks =  = new HashSet<>();
	}

	public Product(int productId, String productName, String productImage, double productPrice, int productRating,
			int noOfProductsViewed, String productBrand, int noOfProducts, String productInfo, String productCategory,
			double productDiscount, boolean productActivated, boolean status, boolean featured, int productMerchantId,
			Set<ProductFeedBack> feedbacks) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productRating = productRating;
		this.noOfProductsViewed = noOfProductsViewed;
		this.productBrand = productBrand;
		this.noOfProducts = noOfProducts;
		this.productInfo = productInfo;
		this.productCategory = productCategory;
		this.productDiscount = productDiscount;
		this.productActivated = productActivated;
		this.status = status;
		this.featured = featured;
		this.productMerchantId = productMerchantId;
		this.feedbacks = feedbacks;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	public int getNoOfProductsViewed() {
		return noOfProductsViewed;
	}

	public void setNoOfProductsViewed(int noOfProductsViewed) {
		this.noOfProductsViewed = noOfProductsViewed;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public int getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public boolean isProductActivated() {
		return productActivated;
	}

	public void setProductActivated(boolean productActivated) {
		this.productActivated = productActivated;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public int getProductMerchantId() {
		return productMerchantId;
	}

	public void setProductMerchantId(int productMerchantId) {
		this.productMerchantId = productMerchantId;
	}

	public Set<ProductFeedBack> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<ProductFeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
}
