package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inti.formation.shop.api.repository.model.Product;
import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;

public interface StockinitRepository extends ReactiveMongoRepository<Stockinit, String>  {

	Flux<Stockinit> findByMagasin(String magasin);
	
	Flux<Stockinit> findByIdProduct(long idproduct);
	
}
