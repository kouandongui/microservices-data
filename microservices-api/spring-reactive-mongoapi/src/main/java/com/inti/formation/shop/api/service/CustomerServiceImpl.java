package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.CustomerRepository;
import com.inti.formation.shop.api.repository.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.joining;
/**
 * @author Sylvanius Kouandongui
 */

@Component
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<Customer>  register(final Customer customer) {

        return customerRepository.save(customer);

    }
    public Flux<Customer> searchName(final String name) {

        return customerRepository.findByName(name);
    }

    public Flux<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> update(final Customer e) {
        return customerRepository.save(e);
    }

}
