package com.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Merchant;

public interface MerchantDAO extends JpaRepository<Merchant, Integer> {

}
