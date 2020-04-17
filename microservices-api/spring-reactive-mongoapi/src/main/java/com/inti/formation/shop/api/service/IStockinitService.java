package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Stockinit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStockinitService {

    public Mono<Stockinit> saveStock(final Stockinit stock);
    public Flux<Stockinit> findAllStock();

}
