package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.StockInit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStockService {
	Mono<StockInit> register(StockInit stockInit);

    public Flux<StockInit> searchIdproduct(long idproduct) ;

    public Flux<StockInit> getstockinit() ;

    public Mono<StockInit> update(StockInit s) ;

}
