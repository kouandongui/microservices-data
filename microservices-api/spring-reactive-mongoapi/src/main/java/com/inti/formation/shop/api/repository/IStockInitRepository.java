package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.StockInit;

import reactor.core.publisher.Flux;
@Repository 
public interface IStockInitRepository extends ReactiveMongoRepository<StockInit, Long> {

	
//	Flux<StockInit> findByMagasin(String magasin);
//	
//	Flux<StockInit> findByIdProduct(Long idproduct);
//	 
//	
//	
//	@Query(value="{"
//            + "'idproduct': {$elemMatch: {'magasin': ?0}}, ")
//    Flux<StockInit> findByMagasinIdproduct(final String magasin, final long idproduct);
//	
//	
}
