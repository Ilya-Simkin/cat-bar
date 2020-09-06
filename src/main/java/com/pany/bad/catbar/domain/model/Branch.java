package com.pany.bad.catbar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection="cat_Branch")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    private String id;

    @Field(name = "branch_name")
    @Indexed(unique = true)
    private String branchName;

    @Field(name = "manager_name")
    private String managerName;

    private Address address;

    @Field(name = "connection_information")
    private ConnectionInformation connectionInformation;

    private List<InventoryObject> inventory;
}
