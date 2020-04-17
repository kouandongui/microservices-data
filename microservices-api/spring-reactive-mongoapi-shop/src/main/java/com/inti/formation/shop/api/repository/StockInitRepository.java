package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.StockInit;
import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.context.properties.ConfigurationProperties;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Collections;
        import java.util.List;

@Repository
public interface StockInitRepository extends ReactiveMongoRepository<StockInit, String> {
    /**
     *
     * @param magasin
     * @return StockInit with parameter name
     */
    Flux<StockInit> findByMagasin(String name);

    /**
     *
     * @param quantite
     * @return Stock with quantity greater than
     */
    @Query(value ="{'quantite':{$gte:?0}}")
    Flux<StockInit> findByQuantite(int quantite);

    /**
     *
     * @param idproduct
     * @return StockInit with parameter idproduct
     */
    Flux<StockInit> findByIdproduct(int idproduct);

}
