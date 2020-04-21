package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.StockinitRepository;
import com.inti.formation.shop.api.repository.model.Stockinit;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class StockinitServiceImpl implements IStockinitService {

	@Autowired
    private StockinitRepository stockinitRepository;
	@Override
	public Mono<Stockinit> register(final Stockinit stockinit) {
		return stockinitRepository.save(stockinit);
	}

	@Override
	public Flux<Stockinit> getStockinit() {
		return stockinitRepository.findAll();
	}

}
