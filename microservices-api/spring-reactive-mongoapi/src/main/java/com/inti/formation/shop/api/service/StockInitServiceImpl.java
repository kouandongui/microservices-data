package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.CustomerRepository;
import com.inti.formation.shop.api.repository.ProductRepository;
import com.inti.formation.shop.api.repository.StockInitRepository;
import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.Product;
import com.inti.formation.shop.api.repository.model.StockInit;

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
public class StockInitServiceImpl implements StockInitService {
	@Autowired
    private StockInitRepository stockInitRepository;
	
	@Override
	public Mono<StockInit> register(StockInit stockInit) {
		// TODO Auto-generated method stub
		return stockInitRepository.save(stockInit);
	}

//	@Override
//	public Flux<Product> searchById(Long id) {
//		// TODO Auto-generated method stub
//		return productRepository.findById(product);
//	}

	@Override
	public Flux<StockInit> getStockInits() {
		// TODO Auto-generated method stub
		return stockInitRepository.findAll();
	}

	@Override
	public Mono<StockInit> update(StockInit s) {
		// TODO Auto-generated method stub
		return stockInitRepository.save(s);
	}
    

}
