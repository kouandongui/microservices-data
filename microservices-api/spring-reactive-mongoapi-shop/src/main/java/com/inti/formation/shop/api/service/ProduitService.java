package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Produit;
import com.inti.formation.shop.api.repository.model.StockInit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sylvanius Kouandongui
 */
public interface ProduitService {

    Mono<Produit> register(Produit produit);

    public Flux<Produit> searchLibelle(String libelle) ;
    public Flux<Produit> searchOrigine(String origine) ;

    public Flux<Produit> getProduits() ;

    public Mono<Produit> update(Produit p) ;

}
