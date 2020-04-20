package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.StockinitRepository;
import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StockinitServiceImpl implements StockinitService {
	
	@Autowired
	private StockinitRepository stockinitRepository;
	

	@Override
	public Mono<Stockinit> createStock(Stockinit stockinit) {
		// TODO Auto-generated method stub
		return stockinitRepository.save(stockinit);
	}

	@Override
	public Flux<Stockinit> getStockinits() {
		// TODO Auto-generated method stub
		return stockinitRepository.findAll();
	}

	@Override
	public Mono<Stockinit> updateStock(Stockinit s) {
		// TODO Auto-generated method stub
		return stockinitRepository.save(s);
	}



}
