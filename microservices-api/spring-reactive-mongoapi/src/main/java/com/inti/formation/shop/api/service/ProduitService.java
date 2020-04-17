package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Produit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Marion Gloriant
 */

public interface ProduitService {
	
	Mono<Produit> register(Produit produit);
	
	public Flux<Produit> getProduits();

}
