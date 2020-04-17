package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.ProduitRepository;
import com.inti.formation.shop.api.repository.StockInitRepository;
import com.inti.formation.shop.api.repository.model.Produit;
import com.inti.formation.shop.api.repository.model.StockInit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sylvanius Kouandongui
 */

@Component
@Slf4j
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Mono<Produit>  register(Produit produit) {
        return produitRepository.save(produit);

    }

    @Override
    public Flux<Produit> searchLibelle(String libelle) {
        return produitRepository.findByLibelle(libelle);
    }

    @Override
    public Flux<Produit> searchOrigine(String origine) {
        return produitRepository.findByOrigine(origine);
    }

    @Override
    public Flux<Produit> getProduits() {
        return produitRepository.findAll();
    }

    public Mono<Produit> update(Produit p) {
        return produitRepository.save(p);

    }

}
