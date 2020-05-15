package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AdminDao;
import com.capgemini.dao.MerchantRepository;
import com.capgemini.entity.MerchantDetails;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private MerchantRepository merchantRepo;
	
	@Autowired
	private MerchantDetails merchant;
	
	@Autowired
	private AdminDao admindao;
	
	
	@Override
	public void addMerchant(MerchantDetails m) {
		// TODO Auto-generated method stub
		//merchantRepo.save(m);
		admindao.addMerchant(m);
		
	}

	@Override
	public void removeMerchant(MerchantDetails m) {
		// TODO Auto-generated method stub
		//admindao.removeMerchantById(userId);
		merchantRepo.delete(m);
	}

	@Override
	public List<MerchantDetails> getAllMerchant() {
		// TODO Auto-generated method stub
		return merchantRepo.findAll();
	}

	@Override
	public void updateMerchant(MerchantDetails m) {
		// TODO Auto-generated method stub
		merchantRepo.save(m);
		
	}

	@Override
	public MerchantDetails findMerchantById(Integer id) {
		// TODO Auto-generated method stub
		admindao.findMerchantById(id);
		return merchantRepo.findById(id).get();
	}

}
