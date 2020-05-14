package com.example.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.model.Product;

@Repository(value="ProductRepository")
public interface ProductRepository extends JpaRepository<Product,Integer> {

	List<Product> findByInventoryId();

	Product findByProductId();

	List<Product> findByProductBrand();

	List<Product> findByProductInfo();

	List<Product> findByProductCategory();

}
