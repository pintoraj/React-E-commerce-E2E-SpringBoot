package com.pinto.ReactEcommerceBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinto.ReactEcommerceBackend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByIsDealOfTheDay(boolean isDeal);
	
}
