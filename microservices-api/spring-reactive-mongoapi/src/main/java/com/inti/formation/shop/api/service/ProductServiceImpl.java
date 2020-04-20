package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.CustomerRepository;
import com.inti.formation.shop.api.repository.ProductRepository;
import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.Product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.joining;
/**
 * @author Sylvanius Kouandongui
 */

@Component
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
    private ProductRepository productRepository;
	
	@Override
	public Mono<Product> register(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

//	@Override
//	public Flux<Product> searchById(Long id) {
//		// TODO Auto-generated method stub
//		return productRepository.findById(product);
//	}

	@Override
	public Flux<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Mono<Product> update(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}
    

}
