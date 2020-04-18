package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.IStockInitRepository;
import com.inti.formation.shop.api.repository.model.StockInit;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class StockInitImpl implements IStockService {

	@Autowired
	private IStockInitRepository stockinitRepository;
	
	@Override
	public Mono<StockInit> register(StockInit stockInit) {
		// TODO Auto-generated method stub
		return stockinitRepository.save(stockInit);
	}

	@Override
	public Flux<StockInit> searchIdproduct(long idproduct) {
		// TODO Auto-generated method stub
		return stockinitRepository.findByIdProduct(idproduct);
	}

	@Override
	public Flux<StockInit> getstockinit() {
		// TODO Auto-generated method stub
		return stockinitRepository.findAll();
	}

	@Override
	public Mono<StockInit> update(StockInit s) {
		// TODO Auto-generated method stub
		return stockinitRepository.save(s);
	}

}
