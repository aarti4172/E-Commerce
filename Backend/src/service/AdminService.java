package com.store.service;

import java.util.List;

import com.capgemini.entity.MerchantDetails;


public interface AdminService {

	
	public void addMerchant(MerchantDetails m);
	public void removeMerchant(MerchantDetails m);
	public List<MerchantDetails> getAllMerchant();
	public void updateMerchant(MerchantDetails m);
	public MerchantDetails findMerchantById(Integer id);
}

