package com.liv2train.app.domain;

import lombok.Data;

@Data
public class Address {

    private String AddressLine1;
    private String AddressLine2;
    private String city;
    private String pincode;
}
