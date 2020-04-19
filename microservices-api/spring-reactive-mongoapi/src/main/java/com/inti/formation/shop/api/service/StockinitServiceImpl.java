package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.IStockinitRepository;
import com.inti.formation.shop.api.repository.model.Stockinit;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class StockinitServiceImpl implements StockinitService{
	
	@Autowired
	private IStockinitRepository stockinitRepository;
	
	@Override
	public Mono<Stockinit> save(final Stockinit stockinit) {
		return stockinitRepository.save(stockinit);
	}
	
	public Flux<Stockinit> searchByMagasin(String magasin) {
		return stockinitRepository.findByMagasin(magasin);
	}
	
//	public Flux<Stockinit> searchByIdproduct(long idproduct) {
//		return stockinitRepository.findById(idproduct);
//	}
	
	public Flux<Stockinit> getStockinit() {
		return stockinitRepository.findAll();
		
	}
	
	public Mono<Stockinit> update(Stockinit s) {
		return stockinitRepository.save(s);
	}

}
