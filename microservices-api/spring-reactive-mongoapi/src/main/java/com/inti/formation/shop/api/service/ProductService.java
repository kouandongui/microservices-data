package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;

public interface ProductService {
 
	Flux<Product> findByLibelle();
	
	Flux<Product> findByFrance();
	
}
