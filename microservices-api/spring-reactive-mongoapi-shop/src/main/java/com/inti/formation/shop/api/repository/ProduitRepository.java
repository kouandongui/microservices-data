package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Produit;
import com.inti.formation.shop.api.repository.model.StockInit;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
/**
 * @author Alexandre Bucamp
 */
@Repository
public interface ProduitRepository extends ReactiveMongoRepository<Produit, String> {

    Flux<Produit> findByLibelle(String libelle);

    Flux<Produit> findByOrigine(String origine);

}
