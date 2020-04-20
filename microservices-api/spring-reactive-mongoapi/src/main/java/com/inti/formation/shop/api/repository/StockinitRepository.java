package com.inti.formation.shop.api.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.shop.api.repository.model.Stockinit;



@Repository
public interface StockinitRepository extends ReactiveMongoRepository<Stockinit, String>  {

//	Flux<Stockinit> findByMagasin(String magasin);
//	
//	Flux<Stockinit> findByIdProduct(long idproduct);
	
}
