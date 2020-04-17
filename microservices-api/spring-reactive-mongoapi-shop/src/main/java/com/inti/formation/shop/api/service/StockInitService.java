package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.StockInit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sylvanius Kouandongui
 */
public interface StockInitService {

    Mono<StockInit> register(StockInit stockInit);

    public Flux<StockInit> searchIdproduct(int idproduct) ;
    public Flux<StockInit> searchMagasin(String magasin) ;
    public Flux<StockInit> searchQuantite(int quantite) ;

    public Flux<StockInit> getStock() ;

    public Mono<StockInit> update(StockInit si) ;

}
