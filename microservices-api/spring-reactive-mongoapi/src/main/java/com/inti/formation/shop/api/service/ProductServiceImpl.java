package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.IProductRepository;
import com.inti.formation.shop.api.repository.model.Product;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ProductServiceImpl implements IProductService{
	@Autowired
private IProductRepository productRepository;
	
	
	@Override
	public Mono<Product> register(final Product product) {
		return productRepository.save(product);
	}

	@Override
	public Flux<Product> getProducts() {
		return productRepository.findAll();
	}

}
