package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.StockInit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sylvanius Kouandongui
 */
public interface StockInitService {

    Mono<StockInit> register(StockInit stockInit);

//    public Flux<StockInit> searchByIdProduct(long idproduct) ;

    public Flux<StockInit> getStockInits() ;

    public Mono<StockInit> update(StockInit s) ;

}
