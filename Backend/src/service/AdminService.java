package com.store.service;

import java.util.List;

import com.store.entity.Merchant;


public interface AdminService {

	
	public void addMerchant(Merchant m);
	public void removeMerchant(Merchant m);
	public List<Merchant> getAllMerchant();
	public void updateMerchant(Merchant m);
	public Merchant findMerchantById(Integer id);
}
