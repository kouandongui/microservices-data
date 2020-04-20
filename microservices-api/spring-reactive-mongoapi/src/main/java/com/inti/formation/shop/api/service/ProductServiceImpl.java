package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.ProductRepository;
import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Flux<Product> findByLibelle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Product> findByFrance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Product> create(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

}
