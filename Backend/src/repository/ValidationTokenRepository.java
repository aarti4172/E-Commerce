package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.model.ValidationToken;

public interface ValidationTokenRepository extends JpaRepository<ValidationToken, String> {

	ValidationToken findByTokenValue(String tokenValue);
}
