package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author aimi-
 *
 */
public interface IStockinitService {
	
	Mono<Stockinit> register(Stockinit stock);
	
	public Flux<Stockinit> searchByIdproduct(Long idproduct);
	
	public Flux<Stockinit> getStocks();
	
	public Mono<Stockinit> update(Stockinit s);
}
