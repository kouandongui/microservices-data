package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Produit;
import com.inti.formation.shop.api.repository.model.StockInit;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProduitRepository extends ReactiveMongoRepository<Produit, String> {
    /**
     *
     * @param libelle
     * @return Produit with parameter name
     */
    Flux<Produit> findByLibelle(String libelle);

    /**
     *
     * @param origine
     * @return Stock with quantity greater than
     */
    Flux<Produit> findByOrigine(String origine);

}
