package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Customer, String> {

}
