package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Stockinit;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IStockinitRepository extends ReactiveMongoRepository<Stockinit, Long> {
   
    Flux<Stockinit> findByMagasin(String magasin);
    
    Flux<Stockinit> findByIdproduct(long idproduct);

    @Query(value="{"
            + "'magasin': {$elemMatch: {'idproduct': ?0}}, ")
    Flux<Stockinit> findByMagasinAndIdproduct(final long idproduct);

}
