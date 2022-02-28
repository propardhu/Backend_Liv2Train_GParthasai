package com.liv2train.app.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liv2train.app.domain.Address;
import java.util.List;
import lombok.Data;

@Data
public class TrainingCenterDTO {

    @JsonProperty("centerCode")
    private String centerCode;

    @JsonProperty("centerName")
    private String centerName;

    @JsonProperty("studentCapacity")
    private Integer studentCapacity;

    @JsonProperty("courseOffered")
    private List<String> courseOffered;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private Address address;
}
