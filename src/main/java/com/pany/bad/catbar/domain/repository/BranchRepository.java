package com.pany.bad.catbar.domain.repository;

import com.pany.bad.catbar.domain.model.Branch;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends ReactiveMongoRepository<Branch, String> {

}
