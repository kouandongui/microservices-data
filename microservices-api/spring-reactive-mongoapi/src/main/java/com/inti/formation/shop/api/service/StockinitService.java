package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockinitService {
	
	Mono<Stockinit> createStock(Stockinit stockinit);
	
	public Flux<Stockinit> getStockinits();
	
	public Mono<Stockinit> updateStock(Stockinit s);
	
//	public Flux<Stockinit> searchMag(String magasin);

}
