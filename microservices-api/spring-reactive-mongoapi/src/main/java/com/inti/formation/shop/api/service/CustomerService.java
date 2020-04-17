package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sylvanius Kouandongui
 */
public interface CustomerService {

    Mono<Customer> saveCustomer(Customer customer);

    public Flux<Customer> searchCustomerName(String name) ;

    public Flux<Customer> findAllCustomers() ;

    public Mono<Customer> updateCustomer(Customer e) ;

}
