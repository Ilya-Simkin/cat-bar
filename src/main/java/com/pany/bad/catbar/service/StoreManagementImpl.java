package com.pany.bad.catbar.service;

import com.pany.bad.catbar.domain.model.Branch;
import com.pany.bad.catbar.domain.model.Customer;
import com.pany.bad.catbar.domain.repository.BranchRepository;
import com.pany.bad.catbar.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class StoreManagementImpl {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<Customer> getAllCustomersSortedByLastNameAndFirstName(){
        Sort sort = Sort.by(Sort.Direction.ASC, "lastName", "firstName"); //"last_name", "first_name"); //todo test
        return customerRepository.findAll(sort);
    }

    public Mono<Page<Branch>> findAllBranchPaged(Pageable pageable) {
        return branchRepository.count()
                .flatMap(branchesCount -> branchRepository.findAll(pageable.getSort())
                        .buffer(pageable.getPageSize(),(pageable.getPageNumber() + 1))
                        .elementAt(pageable.getPageNumber(), new ArrayList<>())
                        .map(branches -> new PageImpl<>(branches, pageable, branchesCount)));
    }
}
