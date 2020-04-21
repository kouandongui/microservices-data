package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;

@Repository
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
   * @return origne française d'un produit
   */
  @Query(value="{'origine': {$eq: 'France'}}")
  Flux<Product> findByOrigineFrançaise(final String origine);
  
  
  
  

}
