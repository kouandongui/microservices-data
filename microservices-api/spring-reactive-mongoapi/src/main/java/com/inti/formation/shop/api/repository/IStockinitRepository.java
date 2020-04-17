package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Stockinit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IStockinitRepository extends ReactiveMongoRepository<Stockinit, String> {
}
