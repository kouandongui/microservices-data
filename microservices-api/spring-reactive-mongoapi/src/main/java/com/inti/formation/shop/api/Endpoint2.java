package com.inti.formation.shop.api;



import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.status;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.inti.formation.shop.api.repository.model.Product;
import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/shop")
@Slf4j
public class Endpoint2 {
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

    @PostMapping(value = "/product/register" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Product is registered" )
    public Mono<String> create(@RequestBody Product product) {

        if( ObjectUtils.anyNotNull(product)  && !ObjectUtils.allNotNull(product.getCouleur(),product.getDescription(), product.getLibelle() )){
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
    @RequestMapping(value = "/product/products/")
    public Flux<Product> getProducts() {
        log.info("All customers searching");
      return productService.getProducts()
              // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( product-> product);
    }
}

