package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.IProductRepository;
import com.inti.formation.shop.api.repository.model.Product;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j    //Causes lombok to generate a logger field.
public class ProductServiceImpl implements IProductService{

	
	@Autowired
	private IProductRepository productRepository;
	
	
	
	@Override
	
	public Mono<Product> register(final Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public Flux<Product> searchlibelle(final String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Product> getProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Mono<Product> update(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}

}
