package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dao.MerchantDAO;
import com.store.entity.Merchant;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private MerchantDAO merchantRepo;
	
	@Autowired
	private Merchant merchant;
	
	@Override
	public void addMerchant(Merchant m) {
		// TODO Auto-generated method stub
		merchantRepo.save(m);
		
	}

	@Override
	public void removeMerchant(Merchant m) {
		// TODO Auto-generated method stub
		merchantRepo.delete(m);
	}

	@Override
	public List<Merchant> getAllMerchant() {
		// TODO Auto-generated method stub
		return merchantRepo.findAll();
	}

	@Override
	public void updateMerchant(Merchant m) {
		// TODO Auto-generated method stub
		merchantRepo.save(m);
		
	}

	@Override
	public Merchant findMerchantById(Integer id) {
		// TODO Auto-generated method stub
		return merchantRepo.findById(id).get();
	}

}
