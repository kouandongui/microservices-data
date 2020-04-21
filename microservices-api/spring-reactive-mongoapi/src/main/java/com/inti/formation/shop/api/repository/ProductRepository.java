package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inti.formation.shop.api.repository.model.Product;

import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, Long> {
	
//	/**
//	 *
//	 * @param libelle
//	 * @return Product with parameter libelle
//	 */
//	Flux<Product> findByLibelle(String libelle);
//
//	/**
//	 *
//	 * @param Origine
//	 * @return Product oder France
//	 */
//	@Query(value = "{'origine': {$eq: 'France'}}")
//	Flux<Product> findByOrigineFrance(final String origine);
}
