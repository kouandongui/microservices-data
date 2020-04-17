package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.StockInitRepository;
import com.inti.formation.shop.api.repository.model.StockInit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.joining;
/**
 * @author Sylvanius Kouandongui
 */

@Component
@Slf4j
public class StockInitServiceImpl implements StockInitService {
    @Autowired
    private StockInitRepository stockInitRepository;

    @Override
    public Mono<StockInit>  register(final StockInit stock) {
        return stockInitRepository.save(stock);

    }

    @Override
    public Flux<StockInit> searchIdproduct(int idproduct) {
        return stockInitRepository.findByIdproduct(idproduct);
    }

    @Override
    public Flux<StockInit> searchMagasin(String magasin) {
        return stockInitRepository.findByMagasin(magasin);
    }

    @Override
    public Flux<StockInit> searchQuantite(int quantite) {
        return stockInitRepository.findByQuantite(quantite);
    }

    @Override
    public Flux<StockInit> getStock() {
        return stockInitRepository.findAll();
    }

    public Mono<StockInit> update(final StockInit si) {
        return stockInitRepository.save(si);

    }

}
