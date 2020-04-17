package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sylvanius Kouandongui
 */
public interface CustomerService {

    Mono<Customer> register(Customer customer);

    public Flux<Customer> searchName(String name) ;

    public Flux<Customer> getCustomers() ;

    public Mono<Customer> update(Customer e) ;

}
