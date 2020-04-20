package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.shop.api.repository.model.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, Long> {

}
