package com.inti.formation.shop.api;



import com.inti.formation.shop.api.repository.model.Produit;
import com.inti.formation.shop.api.repository.model.StockInit;
import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.ProduitService;
import com.inti.formation.shop.api.service.StockInitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.status;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/shop")
@Slf4j
public class Endpoint {
    @Autowired
    StockInitService stockInitService;

    @Autowired
    ProduitService produitService;

    @ExceptionHandler(ValidationParameterException.class)
    public Mono<ResponseEntity<String>> handlerValidationParameterException(ValidationParameterException e) {
        return Mono.just(badRequest().body("Missing parameter: "+ e.getMessage()));
    }
    @ExceptionHandler(InternalServerException.class)
    public Mono<ResponseEntity<String>> handlerInternalServerException() {
        return Mono.just(status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error server has occurred "));
    }
    @PostMapping(value = "/stockRegister" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Stock is registered" )
    public Mono<String> createStock(@RequestBody StockInit stockInit) {

        if( ObjectUtils.anyNotNull(stockInit)  && !ObjectUtils.allNotNull(stockInit.getIdproduct(),stockInit.getMagasin(), stockInit.getQuantite() )){
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error" ));
        }
        return Mono.just(stockInit)
                .map(data->
                {
                     return stockInitService.register( data).subscribe().toString();
                });
    }
    @GetMapping
    @RequestMapping(value = "/stockInitByIdproduct/{idproduct}")
    public Flux<StockInit> getIdproduct(@PathVariable(required = true, name = "idproduct") int idproduct ) {
        log.info("Searching  {} ",idproduct );
        return stockInitService.searchIdproduct(idproduct)
                // uses of doNext
                .doOnNext(p -> log.info(p.getIdproduct()+ " is found"));

    }
    @GetMapping
    @RequestMapping(value = "/stockInitByMagasin/{magasin}")
    public Flux<StockInit> getMagasin(@PathVariable(required = true, name = "magasin") String magasin ) {
        log.info("Searching  {} ",magasin );
        return stockInitService.searchMagasin(magasin)
                // uses of doNext
                .doOnNext(p -> log.info(p.getMagasin()+ " is found"));

    }
    @GetMapping
    @RequestMapping(value = "/stockInitByQuantity/{quantite}")
    public Flux<StockInit> getQuantite(@PathVariable(required = true, name = "quantite") int quantite ) {
        log.info("Searching  {} ",quantite );
        return stockInitService.searchQuantite(quantite)
                // uses of doNext
                .doOnNext(p -> log.info(p.getQuantite()+ " is found"));

    }
    @GetMapping
    @RequestMapping(value = "/stockInits")
    public Flux<StockInit> getStock() {
        log.info("All stockInits searching");
      return stockInitService.getStock()
              // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( stockInit-> stockInit);
    }


    @PostMapping(value = "/produitRegister" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Produit is registered" )
    public Mono<String> createProduit(@RequestBody Produit produit) {

        if( ObjectUtils.anyNotNull(produit)  && !ObjectUtils.allNotNull(produit.getLibelle(),produit.getOrigine(), produit.getDescription() )){
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error" ));
        }
        return Mono.just(produit)
                .map(data->
                {
                    return produitService.register( data).subscribe().toString();
                });
    }
    @GetMapping
    @RequestMapping(value = "/produitByLibelle/{libelle}")
    public Flux<Produit> getLibelle(@PathVariable(required = true, name = "libelle") String libelle ) {
        log.info("Searching  {} ",libelle );
        return produitService.searchLibelle(libelle)
                // uses of doNext
                .doOnNext(p -> log.info(p.getLibelle()+ " is found"));

    }
    @GetMapping
    @RequestMapping(value = "/produitByOrigine/{origine}")
    public Flux<Produit> getOrigine(@PathVariable(required = true, name = "origine") String origine ) {
        log.info("Searching  {} ",origine );
        return produitService.searchOrigine(origine)
                // uses of doNext
                .doOnNext(p -> log.info(p.getOrigine()+ " is found"));

    }
    @GetMapping
    @RequestMapping(value = "/produits")
    public Flux<Produit> getProduits() {
        log.info("All produits searching");
        return produitService.getProduits()
                // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( produit-> produit);
    }
    @PutMapping(value = "/produitUpdate" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Produit is updated" )
    public Mono<String> updateProduit(@RequestBody Produit produit) {

        if( ObjectUtils.anyNotNull(produit)  && !ObjectUtils.allNotNull(produit.getLibelle(),produit.getOrigine(), produit.getDescription() )){
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error" ));
        }
        return Mono.just(produit)
                .map(data->
                {
                    return produitService.update( data).subscribe().toString();
                });
    }
}

