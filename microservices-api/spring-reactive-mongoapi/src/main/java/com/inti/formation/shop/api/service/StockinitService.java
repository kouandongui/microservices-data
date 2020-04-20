package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;

public interface StockinitService {
	
	Flux<Stockinit> findByMagasin();
	
	Flux<Stockinit> findByIdProduct();
	

}
