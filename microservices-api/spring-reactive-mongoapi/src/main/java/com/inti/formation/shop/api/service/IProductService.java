package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {

    public Mono<Product> saveProduct(Product product);
    public Flux<Product> findAllProduct();

}
