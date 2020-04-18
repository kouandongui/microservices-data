package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface StockinitService {

    Mono<Stockinit> register(Stockinit stockinit);

    public Flux<Stockinit> searchMagasin(String magasin) ;
    
    public Flux<Stockinit> searchIdproduct(long stockinitidprod) ;

    public Flux<Stockinit> getStockinits() ;

    public Mono<Stockinit> update(Stockinit s) ;

}
