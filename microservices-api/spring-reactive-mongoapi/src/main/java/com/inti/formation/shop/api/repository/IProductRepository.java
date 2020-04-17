package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;
import java.lang.String;
import java.util.List;

public interface IProductRepository extends ReactiveMongoRepository<Product, Long> {
    /**
    *
    * @param libelle
    * @return Product with parameter libelle
    */
   Flux<Product> findByLibelle(String libelle);

   /**
    *
    * @param origine
    * @return Product oder origine
    */
   @Query(value="{'origine': {$eq: 'France'}}")
   Flux<Product>findByOrigineFr(final String origine);

}
