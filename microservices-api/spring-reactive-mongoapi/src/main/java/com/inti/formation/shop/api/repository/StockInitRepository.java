package com.inti.formation.shop.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.inti.formation.shop.api.repository.model.StockInit;

/**
 * @author Marion Gloriant
 */

@Repository
public interface StockInitRepository extends ReactiveMongoRepository<StockInit, Integer>  {

}
