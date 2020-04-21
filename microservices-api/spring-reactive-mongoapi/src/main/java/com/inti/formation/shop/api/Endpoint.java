package com.inti.formation.shop.api;



import com.inti.formation.shop.api.repository.model.Customer;
import com.inti.formation.shop.api.repository.model.Product;
import com.inti.formation.shop.api.repository.model.Stockinit;
import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.*;
import com.inti.formation.shop.api.rest.bean.CustomerRequest;
import com.inti.formation.shop.api.rest.exception.InternalServerException;
import com.inti.formation.shop.api.rest.exception.ValidationParameterException;
import com.inti.formation.shop.api.service.CustomerService;
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
    IProductService productService;

    @Autowired
    IStockinitService stockinitService;

    @ExceptionHandler(ValidationParameterException.class)
    public Mono<ResponseEntity<String>> handlerValidationParameterException(ValidationParameterException e) {
        return Mono.just(badRequest().body("Missing parameter: " + e.getMessage()));
    }

    @ExceptionHandler(InternalServerException.class)
    public Mono<ResponseEntity<String>> handlerInternalServerException() {
        return Mono.just(status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error server has occurred "));
    }
    
    @PostMapping(value = "/register", headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Customer is registered")
    public Mono<String> create(@RequestBody Customer customer) {

        if (ObjectUtils.anyNotNull(customer) && !ObjectUtils.allNotNull(customer.getEmail(), customer.getName(), customer.getFirstname())) {
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error"));
        }
        return Mono.just(customer)
                .map(data ->
                {
                    return customerService.saveCustomer(data).subscribe().toString();
                });
    }

    @GetMapping
    @RequestMapping(value = "/customers{customername}")
    public Flux<Customer> getCustomers(@RequestParam(required = true, name = "customername") String customername ) {
        log.info("Searching  {} ",customername );
        return customerService.searchCustomerName(customername)

                // uses of doNext

                .doOnNext(customer -> log.info(customer.getEmail()+ " is found"));
    }



    @GetMapping
    @RequestMapping(value = "/customers/")
    public Flux<Customer> getCustomers() {
        log.info("All customers searching");
        return customerService.findAllCustomers()
                // uses of map
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(customer -> customer);
    }

    @GetMapping
    @RequestMapping(value = "/products")
    public Flux<Product> getProducts() {
        return productService.findAllProduct()
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(product -> product);
    }

    @PostMapping(value = "/saveProduct", headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Product is registered")
    public Mono<String> createProduct(@RequestBody Product product) {

        if (ObjectUtils.anyNotNull(product) && !ObjectUtils.allNotNull(product.getCouleur(), product.getDescription(), product.getLibelle(), product.getOrigine())) {
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error"));
        }
        return Mono.just(product)
                .map(data ->
                {
                    return productService.saveProduct(data).subscribe().toString();
                });

    }

    @GetMapping
    @RequestMapping(value = "/stocks")
    public Flux<Stockinit> getStocks() {
        return stockinitService.findAllStock()
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(stock -> stock);
    }

    @PostMapping(value = "/saveStock", headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Product is registered")
    public Mono<String> createStock(@RequestBody Stockinit stock) {

        if (ObjectUtils.anyNotNull(stock) && !ObjectUtils.allNotNull(stock.getActive(), stock.getIdproduct(), stock.getMagasin(), stock.getQuantite())) {
            log.error("Validation error: one of parameter is not found");
            return Mono.error(new ValidationParameterException("Validation error"));
        }
        return Mono.just(stock)
                .map(data ->
                {
                    return stockinitService.saveStock(data).subscribe().toString();
                });

    }

}

