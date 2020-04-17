package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.StockInitRepository;
import com.inti.formation.shop.api.repository.model.StockInit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Marion Gloriant
 */

@Component
public class StockInitServiceImpl implements StockInitService {
	
	@Autowired
	private StockInitRepository stockinitrepository;
	
	@Override
	public Mono<StockInit> register(StockInit stockinit) {
		return stockinitrepository.save(stockinit);
	}

	@Override
	public Flux<StockInit> getStockInits() {
		return stockinitrepository.findAll();
	}

}
