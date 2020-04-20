package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sylvanius Kouandongui
 */
public interface ProductService {

    Mono<Product> register(Product product);

//    public Flux<Product> searchById(Long id) ;

    public Flux<Product> getProducts() ;

    public Mono<Product> update(Product p) ;

}
