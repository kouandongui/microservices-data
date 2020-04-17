package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;
import java.lang.String;

public interface IStockinitRepository extends ReactiveMongoRepository<Stockinit, Long> {
	 /**
    *
    * @param magasin
    * @return Stockinit with parameter magasin
    */
   Flux<Stockinit> findByMagasin(String magasin);

   /**
    *
    * @param idproduct
    * @return Stockinit oder idproduct
    */
   Flux<Stockinit> findByIdproduct(long idproduct);

   /**
    *
    * @param 
    * @return
    */
   @Query(value="{"+ "'magasin': {$elemMatch: {'idproduct': ?0}} ")
   Flux<Stockinit> findByMagasinAndIdproduct(final String magasin, final long idproduct);

}