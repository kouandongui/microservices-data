package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.IStockinitRepository;
import com.inti.formation.shop.api.repository.model.Stockinit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class StockinitServiceImpl implements StockinitService {
    @Autowired
    private IStockinitRepository stockinitRepository;

    @Override
    public Mono<Stockinit>  register(final Stockinit stockinit) {
        return stockinitRepository.save(stockinit);

    }
    
    public Flux<Stockinit> getStockinits() {
        return stockinitRepository.findAll();
    }

    public Mono<Stockinit> update(final Stockinit s) {
        return stockinitRepository.save(s);
    }
    
	public Flux<Stockinit> searchMagasin(String magasin) {
		  return stockinitRepository.findByMagasin(magasin);
	}
	
	public Flux<Stockinit> searchIdproduct(long idproduct) {
		return stockinitRepository.findByIdproduct(idproduct);
	}
	
}