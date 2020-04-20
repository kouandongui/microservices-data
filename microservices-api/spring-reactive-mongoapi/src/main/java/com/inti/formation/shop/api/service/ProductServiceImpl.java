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
	public Mono<Product> create(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Mono<Product> update(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}

	@Override
	public Flux<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Flux<Product> searchLibelle(String libelle) {
		// TODO Auto-generated method stub
		return productRepository.findByLibelle(libelle);
	}

}
