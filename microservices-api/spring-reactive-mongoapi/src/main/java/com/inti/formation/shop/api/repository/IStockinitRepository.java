package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


import com.inti.formation.shop.api.repository.model.Stockinit;

import reactor.core.publisher.Flux;

@Repository
public interface IStockinitRepository extends ReactiveMongoRepository<Stockinit, Long> {
	
	 /**
    *
    * @param magasin
    * @return un stockinit par un magasin 
    */
   Flux<Stockinit> findByMagasin(String magasin);
   
   
   /**
   *
   * @param name
   * @return
   */
  Flux<Stockinit> findByIdproduct(long idproduct);
   
   
   /**
   *
   * @param name
   * @return
   */
//  @Query(value="{'idproduct':{$elemMatch: {'magasin': ?0}, } ")
//  Flux<Stockinit> findByIdproductMag(final String magasin, final long idproduct);
   
   
	
	

}
