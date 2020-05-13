package com.store.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="Inventory")
public class Inventory {

	private Set<Product> products;

	public Inventory() {
		products = new HashSet<Product>();
	}

	public Inventory(Set<Product> products) {
		super();
		this.products = products;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
		
}
