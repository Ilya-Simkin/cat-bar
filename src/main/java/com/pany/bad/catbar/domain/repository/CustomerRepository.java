package com.pany.bad.catbar.domain.repository;

import com.pany.bad.catbar.domain.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    Mono<Customer> findByFirstName(String name);

    Flux<Customer> findByAddressCountry(String countryName);
}
