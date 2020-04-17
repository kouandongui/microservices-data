package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductService repo;


    @Override
    public Mono<Product> saveProduct(Product product) {
        return repo.saveProduct(product);
    }

    @Override
    public Flux<Product> findAllProduct() {
        return repo.findAllProduct();
    }
}
