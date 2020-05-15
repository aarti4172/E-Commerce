package com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Merchant;

public interface MerchantRepository extends JpaRepository<MerchantDetails, Integer> {

}
