package com.capstore.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.app.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProductInfo(String productInfo);

	List<Product> findByProductBrand(String productBrand);

	List<Product> findByProductCategory(String productCategory);

}
