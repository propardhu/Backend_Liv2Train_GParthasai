package com.liv2train.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

    @JsonProperty("addressLine1")
    private String AddressLine1;

    @JsonProperty("addressLine2")
    private String AddressLine2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("pinCode")
    private String pincode;
}
