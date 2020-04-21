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
import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    /**
     * A = Query in methode name
     * @param name
     * @return Customer with parameter name
     */
    Flux<Customer> findByName(String name);

    /**
     * B = Query in annotation
     * @param name
     * @return
     */
    @Query("{ 'name' : ?0 }")
    Flux<Customer> searchName(String name);


    /**
     * C
     * Utilisation de Or avec le nom de la méthode
     * @param name
     * @param firstname
     * @return
     */

    Flux<Customer> findByNameOrFirstname(final String name, final String firstname );

    /**
     * Utilisation de or avec query annotation
     * D = C
     * @param name
     * @param firstname
     * @return
     */
    @Query("{'$or':[ {'name':?0}, {'firstname':?1} ] }")
    Flux<Customer> searchNameOrFirstname(final String name, final String firstname );


    /**
     * Utilisation de And avec le nom de la méthode
     * @param name
     * @param firstname
     * @return
     */
    Flux<Customer> findByNameAndFirstname(final String name, final String firstname );




    /**
     * Utilisation de And avec query annotation
     * @param name
     * @param firstname
     * @return
     */
    @Query("{'$and':[ {'name':?0}, {'firstname':?1} ] }")
    Flux<Customer> searchNameAndFirstname(final String name, final String firstname );


    /**
     *
     * @param date
     * @return
     */
    @Query(value="{'date': {$gte: ?0}}")
    Flux<Customer> findByCustomerOlder(final Date date);


    /**
     *
     * @param date1
     * @param date2
     * @return
     */
    Flux<Customer> findByDateNaissanceBetween( final Date date1,  final Date date2);


}
