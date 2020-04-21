package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.IProductRepository;
import com.inti.formation.shop.api.repository.model.Product;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * 
 * @author aimi-
 *
 */
@Component
@Slf4j
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductRepository repository;
	
	
	@Override
	public Mono<Product> register(Product product) {
		
		return repository.save(product);
	}

	
	public Flux<Product> searchlibelle(String libelle) {
		
		return repository.findByLibelle(libelle);
	}

	
	public Flux<Product> getProducts() {
	
		return repository.findAll();
	}

	
	public Mono<Product> update(Product p) {
		
		return repository.save(p);
	}


	@Override
	public void delete(Long id) {
		
		repository.deleteById(id);
		
	}


	

}
