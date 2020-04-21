package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.Product;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, Long> {
   
//	Flux<Product> findByLibelle(String libelle);
//
//	@Query(value = "{'origine': {$eq: 'France'}}")
//	Flux<Customer> findByCustomerAge(final int age);

}
