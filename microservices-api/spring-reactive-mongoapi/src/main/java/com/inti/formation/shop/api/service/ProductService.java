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

	
	Mono<Product> create(Product product);
	
	public Mono<Product> update(Product p);
	
	public Flux<Product> getProducts();
	
	public Flux<Product> searchLibelle(String libelle);
}
