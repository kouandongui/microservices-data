package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.StockInit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Marion Gloriant
 */

public interface StockInitService {
	
	Mono<StockInit> register(StockInit stockinit);
	
	public Flux<StockInit> getStockInits();
	

}
