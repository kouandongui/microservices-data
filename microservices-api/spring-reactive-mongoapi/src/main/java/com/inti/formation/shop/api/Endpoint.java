package com.inti.formation.shop.api;



import com.inti.formation.shop.api.repository.model.Customer;

import com.inti.formation.shop.api.repository.model.Product;
import com.inti.formation.shop.api.repository.model.Stockinit;
import com.inti.formation.shop.api.rest.bean.CustomerRequest;

import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.CustomerService;
import com.inti.formation.shop.api.service.IProductService;
import com.inti.formation.shop.api.service.IStockinitService;

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
// Controller , Roote
public class Endpoint {
    @Autowired
    CustomerService customerService;
    
    @Autowired
    IProductService repository;
    
    @Autowired
    IStockinitService stockrepo;

    @ExceptionHandler(ValidationParameterException.class)
    public Mono<ResponseEntity<String>> handlerValidationParameterException(ValidationParameterException e) {
     return Mono.just(
                badRequest().body("Missing parameter: "+ e.getMessage()));
    }

    @ExceptionHandler(InternalServerException.class)
    public Mono<ResponseEntity<String>> handlerInternalServerException() {
        return Mono.just(status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error server has occurred "));
    }

    @PostMapping(value = "/register" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Customer is registered" )
    public Mono<String> create(@RequestBody CustomerRequest customer) {

        if( ObjectUtils.anyNotNull(customer)  && !ObjectUtils.allNotNull(customer.getEmail(),customer.getName(), customer.getFirstname() )){
            log.error("Validation error: one of attributes is not found");
            return Mono.error(new ValidationParameterException("(Validation error message): one of attributes is not found" ));
        }
        return Mono.just(customer)
        .map(data->
                {

                    return customerService.register( data).subscribe().toString();

                });
    }



    @PostMapping(value = "/register/product" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Product is registered" )
    public Mono<String> create(@RequestBody Product product) {

        if( ObjectUtils.anyNotNull(product)  && !ObjectUtils.allNotNull(product.getLibelle(),product.getId(), product.getCouleur() )){
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error" ));
        }
        return Mono.just(product)
                .map(data->
                {
                     return repository.register( data).subscribe().toString();
                });
    } 
    
    
    @PostMapping(value = "/register/stock" , headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus( value  = HttpStatus.CREATED, reason="Stock is registered" )
    public Mono<String> create(@RequestBody Stockinit stock) {

        if( ObjectUtils.anyNotNull(stock)  && !ObjectUtils.allNotNull(stock.getMagasin(),stock.getId(), stock.getQuantite())){
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error" ));
        }
        return Mono.just(stock)
                .map(data->
                {
                     return stockrepo.register( data).subscribe().toString();
                });
    } 
    
    
    
    
    
    
    
    
    
    

    @GetMapping
    @RequestMapping(value = "/customers{customername}")

    public Flux<Customer> getCustomers(@RequestParam(required = true, name = "customername") String customername ) {
        log.info("Searching  {} ",customername );
        return customerService.searchName(customername)

                // uses of doNext

                .doOnNext(customer -> log.info(customer.getEmail()+ " is found"));

    }



    @GetMapping
    @RequestMapping(value = "/customers/")
    public Flux<Customer> getCustomers() {
        log.info("All customers searching");
      return customerService.getCustomers()
              // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( data-> data);
    }
    
    
    
    
    @GetMapping
    @RequestMapping(value = "/Products{libelle}")
    public Flux<Product> getProducts(@RequestParam(required = true, name = "libelle") String libelle ) {
        log.info("Searching  {} ",libelle );
        return repository.searchlibelle(libelle)
                // uses of doNext
                .doOnNext(p -> log.info(p.getLibelle()+ " is found"));

    }

    
    
    @GetMapping
    @RequestMapping(value = "/Products/")
    public Flux<Product> getProducts() {
        log.info("All products searching");
      return repository.getProducts()
              // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( product-> product);
    }
    
    @DeleteMapping
    @RequestMapping(value= "/Product/delete{id}")
    public void delete(@RequestParam(required = true, name = "id") Long id) {
    	
    	log.info("The product is deleted", id);
    	//uses of map
    	
    	
    	
    	
    }
    
    
    
    
    
    //.................................
    
    @GetMapping
    @RequestMapping(value = "/Stocks{customername}")
    public Flux<Stockinit> getStocks(@RequestParam(required = true, name = "stockid") Long stockid ) {
        log.info("Searching  {} ", stockid );
        return stockrepo.searchByIdproduct(stockid)
                // uses of doNext
                .doOnNext(p -> log.info(p.getIdproduct()+ " is found"));

    }


    @GetMapping
    @RequestMapping(value = "/Stocks/")
    public Flux<Stockinit> getStocks() {
        log.info("All stocks searching");
      return stockrepo.getStocks()
              // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map( stockinit-> stockinit);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

