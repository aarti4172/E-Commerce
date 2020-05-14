package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.model.Inventory;

@Repository("InventoryRepository")
public interface InventoryRepository extends JpaRepository<Inventory,Integer>{

}
