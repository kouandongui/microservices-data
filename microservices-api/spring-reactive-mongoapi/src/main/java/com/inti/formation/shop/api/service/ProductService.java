package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ProductService {

    Mono<Product> register(Product product);

    public Flux<Product> getProducts() ;

    public Mono<Product> update(Product p) ;

	public Flux<Product> searchLibelle(String libelle);

}
