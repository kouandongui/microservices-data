package com.inti.formation.shop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inti.formation.shop.api.repository.ProduitRepository;
import com.inti.formation.shop.api.repository.model.Produit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Marion Gloriant
 */

@Component
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public Mono<Produit> register(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public Flux<Produit> getProduits() {
		return produitRepository.findAll();
	}

}
