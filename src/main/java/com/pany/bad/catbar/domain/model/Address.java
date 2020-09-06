package com.pany.bad.catbar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String country;

    private String city;

    private String street;

    private Long houseNumber;

    @GeoSpatialIndexed(name="Location" ,type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;


}
