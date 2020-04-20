package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockinitService {
	
	Mono<Stockinit> save(final Stockinit stockinit);
	
	public Flux<Stockinit> searchByMagasin(String magasin);
	
//	public Flux<Stockinit> searchByIdproduct(long idproduct);
	
	public Flux<Stockinit> getStockinit();
	
	public Mono<Stockinit> update(Stockinit s);
	

}
