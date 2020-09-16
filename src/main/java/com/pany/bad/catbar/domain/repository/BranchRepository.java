package com.pany.bad.catbar.domain.repository;

import com.pany.bad.catbar.domain.model.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BranchRepository extends ReactiveMongoRepository<Branch, String> {

    Flux<Branch> findByManagerNameOrderByBranchName(String managerName, Pageable pageable);

    Flux<Branch> findByBranchNameStartsWith(String branchNameStartWith);

}
