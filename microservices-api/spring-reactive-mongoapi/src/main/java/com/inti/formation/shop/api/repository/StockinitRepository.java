package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inti.formation.shop.api.repository.model.Stockinit;

public interface StockinitRepository extends ReactiveMongoRepository<Stockinit, String>  {

}
