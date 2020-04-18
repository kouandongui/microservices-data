package com.inti.formation.shop.api;


import com.inti.formation.shop.api.repository.model.Product;
import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.ProductService;

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
public class EndpointProduct {
    @Autowired
    ProductService productService;

    @ExceptionHandler(ValidationParameterException.class)
    public Mono<ResponseEntity<String>> handlerValidationParameterException(ValidationParameterException e) {
        return Mono.just(badRequest().body("Missing parameter: "+ e.getMessage()));
    }

    @ExceptionHandler(InternalServerException.class)
    public Mono<ResponseEntity<String>> handlerInternalServerException() {
        return Mono.just(status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error server has occurred "));
    }

    @PostMapping(value = "/register" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Product is registered" )
    public Mono<String> create(@RequestBody Product product) {

        if( ObjectUtils.anyNotNull(product)  && !ObjectUtils.allNotNull(product.getId(),product.getLibelle(),product.getOrigine(),product.getDescription(),product.getCouleur() )){
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error" ));
        }
        return Mono.just(product)
                .map(data->
                {
                     return productService.register( data).subscribe().toString();
                });
    }


    @GetMapping
    @RequestMapping(value = "/product{productlib}")
    public Flux<Product> getProducts(@RequestParam(required = true, name = "productlib") String productlib ) {
        log.info("Searching  {} ",productlib );
        return productService.searchLibelle(productlib)
                // uses of doNext
                .doOnNext(p -> log.info(p.getLibelle()+ " is found"));

    }


    @GetMapping
    @RequestMapping(value = "/products/")
    public Flux<Product> getProducts() {
        log.info("All product searching");
      return productService.getProducts()
              // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( product-> product);
    }
}

