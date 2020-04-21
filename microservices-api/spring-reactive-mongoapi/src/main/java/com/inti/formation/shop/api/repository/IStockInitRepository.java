package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;

@Repository
public interface IStockInitRepository extends ReactiveMongoRepository<Stockinit, Long>  {

//Flux<Stockinit> findByMagasin(String magasin);	
//Flux<Stockinit> findByIdProduct(long idproduct);
//
//@Query(value="{"
//        + "'magasin': {$elemMatch: {'idproduct': ?0}}, ")
//Flux<Stockinit> findByMagasinAndIdProduct(final String magasin, final long idproduct);
}
