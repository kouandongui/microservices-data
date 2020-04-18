package com.inti.formation.shop.api;



import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.Stockinit;
import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.CustomerService;
import com.inti.formation.shop.api.service.StockinitService;

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
public class EndpointStockinit {
    @Autowired
    StockinitService stockinitService;

    @ExceptionHandler(ValidationParameterException.class)
    public Mono<ResponseEntity<String>> handlerValidationParameterException(ValidationParameterException e) {
        return Mono.just(badRequest().body("Missing parameter: "+ e.getMessage()));
    }

    @ExceptionHandler(InternalServerException.class)
    public Mono<ResponseEntity<String>> handlerInternalServerException() {
        return Mono.just(status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error server has occurred "));
    }

    @PostMapping(value = "/register" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Stockinit is registered" )
    public Mono<String> create(@RequestBody Stockinit stockinit) {

        if( ObjectUtils.anyNotNull(stockinit)  && !ObjectUtils.allNotNull(stockinit.getId(),stockinit.getQuantite(), stockinit.getMagasin(), stockinit.getIdproduct(), stockinit.getDate() )){
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error" ));
        }
        return Mono.just(stockinit)
                .map(data->
                {
                     return stockinitService.register( data).subscribe().toString();
                });
    }


    @GetMapping
    @RequestMapping(value = "/stockinits{stockinitmagasin}")
    public Flux<Stockinit> getStockinitsMag(@RequestParam(required = true, name = "stockinitmagasin") String stockinitmagasin ) {
        log.info("Searching  {} ",stockinitmagasin );
        return stockinitService.searchMagasin(stockinitmagasin)
                // uses of doNext
                .doOnNext(p -> log.info(p.getMagasin()+ " is found"));

    }


    @GetMapping
    @RequestMapping(value = "/stockinits{stockinitidprod}")
    public Flux<Stockinit> getStockinitsIdP(@RequestParam(required = true, name = "stockinitidprod") long stockinitidprod ) {
        log.info("Searching  {} ",stockinitidprod );
        return stockinitService.searchIdproduct(stockinitidprod)
                // uses of doNext
                .doOnNext(p -> log.info(p.getIdproduct()+ " is found"));

    }

    @GetMapping
    @RequestMapping(value = "/stockinits/")
    public Flux<Stockinit> getStockinits() {
        log.info("All customers searching");
      return stockinitService.getStockinits()
              // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( stockinit-> stockinit);
    }
}

