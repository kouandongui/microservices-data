package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.IStockinitRepository;
import com.inti.formation.shop.api.repository.model.Stockinit;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author aimi-
 *
 */
@Component
@Slf4j
public class StockinitServiceImpl implements IStockinitService {

	
	@Autowired
	private IStockinitRepository repository;
	
	@Override
	public Mono<Stockinit> register(Stockinit stock) {
		
		return repository.save(stock);
	}

	
	public Flux<Stockinit> searchByIdproduct(Long idproduct) {
		
		return repository.findByIdproduct(idproduct);
	}

	
	public Flux<Stockinit> getStocks() {
		
		return repository.findAll();
	}

	
	public Mono<Stockinit> update(Stockinit s) {
		
		return repository.save(s);
	}

}
