package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author lilas
 *
 */
public interface ProductService {
 
	Flux<Product> findByLibelle();
	
	Flux<Product> findByFrance();

	Mono<Product> create(Product data);
	
}
