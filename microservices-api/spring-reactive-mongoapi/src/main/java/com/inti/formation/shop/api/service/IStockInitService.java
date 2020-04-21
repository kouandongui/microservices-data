package com.inti.formation.shop.api.service;


import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStockInitService {

	
	Mono<Stockinit> register(final Stockinit stockinit);
	public Flux<Stockinit> getStockinits() ;
}
