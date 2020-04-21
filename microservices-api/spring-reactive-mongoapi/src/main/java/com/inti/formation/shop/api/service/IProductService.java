package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author aimi-
 *
 */
public interface IProductService {
	
	Mono<Product> register(Product product);
	
	public void delete(Long id);
	
	public Flux<Product> searchlibelle(String libelle);
	
	public Flux<Product> getProducts();
	
	public Mono<Product> update(Product p);

}
