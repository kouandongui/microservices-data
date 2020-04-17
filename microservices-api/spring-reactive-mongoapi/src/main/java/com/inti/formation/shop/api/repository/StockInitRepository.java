package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.StockInit;

import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.context.properties.ConfigurationProperties;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Collections;
        import java.util.List;

@Repository
public interface StockInitRepository extends ReactiveMongoRepository<StockInit, Long> {
    
    Flux<StockInit> findByMagasin(String magasin);
   /* Flux<StockInit> findByIdProduct(long idproduct);
    */
    

    
    @Query(value="{"
            + "'magasin': {$elemMatch: {'idproduct': ?0}}, ")
    Flux<StockInit> findByMagAndIdProduct(final String magasin);

}
