package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
	
	 Mono<Product> register(Product product);

	    public Flux<Product> searchlibelle(String libelle) ;

	    public Flux<Product> getProduct() ;

	    public Mono<Product> update(Product p) ;
	
	

}
