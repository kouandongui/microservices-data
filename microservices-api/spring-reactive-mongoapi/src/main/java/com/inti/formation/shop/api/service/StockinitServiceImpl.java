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
public class StockinitServiceImpl implements IStockinitService {

    @Autowired
    private IStockinitRepository repo;


    @Override
    public Mono<Stockinit> saveStock(final Stockinit stock) {
        return repo.save(stock);
    }

    @Override
    public Flux<Stockinit> findAllStock() {
        return repo.findAll();
    }
}
