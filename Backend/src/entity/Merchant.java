package com.store.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="merchant")
public class Merchant {

	@Id
	private int merchant_id;
	
	private String username;
	
	private String name;
	
    private String phone_no;
	
	private String altPhone_no;
	
   private String email;
	
	private Set<Order> orders;
	
	private Set<Address> addresses;
	
	private Set<Coupons> coupons;
	
	private Set<Product> products;
	
    private Set<CommonFeedback> feedbacks;
    
    private boolean isApproved;
    
    private int rating;

	public Merchant(int merchant_id, String username, String name, String phone_no, String altPhone_no, String email,
			Set<Order> orders, Set<Address> addresses, Set<Coupons> coupons, Set<Product> products,
			Set<CommonFeedback> feedbacks, boolean isApproved, int rating) {
		super();
		this.merchant_id = merchant_id;
		this.username = username;
		this.name = name;
		this.phone_no = phone_no;
		this.altPhone_no = altPhone_no;
		this.email = email;
		this.orders = orders;
		this.addresses = addresses;
		this.coupons = coupons;
		this.products = products;
		this.feedbacks = feedbacks;
		this.isApproved = isApproved;
		this.rating = rating;
	}

	public Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAltPhone_no() {
		return altPhone_no;
	}

	public void setAltPhone_no(String altPhone_no) {
		this.altPhone_no = altPhone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Coupons> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupons> coupons) {
		this.coupons = coupons;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<CommonFeedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<CommonFeedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Merchant [merchant_id=" + merchant_id + ", username=" + username + ", name=" + name + ", phone_no="
				+ phone_no + ", altPhone_no=" + altPhone_no + ", email=" + email + ", orders=" + orders + ", addresses="
				+ addresses + ", coupons=" + coupons + ", products=" + products + ", feedbacks=" + feedbacks
				+ ", isApproved=" + isApproved + ", rating=" + rating + "]";
	}
    
    
	
	
	
}
