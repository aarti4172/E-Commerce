package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.model.MerchantDetails;
import com.example.main.model.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
