package com.pany.bad.catbar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "cat_customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Field(name = "connection_information")
    private ConnectionInformation connectionInformation;

    private Address address;

    @DBRef(lazy = true)
    @Field(name = "previously_purchased")
    private final Set<Product> previouslyPurchased = new HashSet<>();

}
