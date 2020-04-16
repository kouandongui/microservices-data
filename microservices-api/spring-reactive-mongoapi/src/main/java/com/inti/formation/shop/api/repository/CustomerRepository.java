package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Customer;
import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.context.properties.ConfigurationProperties;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Collections;
        import java.util.List;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    /**
     *
     * @param name
     * @return Customer with parameter name
     */
    Flux<Customer> findByName(String name);

    /**
     *
     * @param age
     * @return Customer oder age
     */
    @Query(value="{'age': {$gte: ?0}}")
    Flux<Customer> findByCustomerAge(final int age);

    /**
     *
     * @param name
     * @return
     */
    @Query(value="{"
            + "'articles': {$elemMatch: {'name': ?0}}, ")
    Flux<Customer> findByCustomerName(final String name);

}
