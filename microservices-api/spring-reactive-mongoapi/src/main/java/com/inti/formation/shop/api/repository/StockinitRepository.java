package com.inti.formation.shop.api.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;



@Repository
public interface StockinitRepository extends ReactiveMongoRepository<Stockinit, String>  {

	/**
	 * 
	 * @param id
	 * @return Stockinit with parameter id
	 */
	Flux<Stockinit> findById(Long id);

	
//	Flux<Stockinit> findByMagasin(String magasin);
//	
//	Flux<Stockinit> findByIdProduct(long idproduct);
	
}
