package com.pany.bad.catbar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryObject {

    @DBRef(lazy = true)
    private Product product;

    private Long amount;
}
