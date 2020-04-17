package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IStockinitRepository extends ReactiveMongoRepository<Customer, String> {
}
