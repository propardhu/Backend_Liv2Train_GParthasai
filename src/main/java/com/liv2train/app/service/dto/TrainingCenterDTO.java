package com.liv2train.app.service.dto;

import com.liv2train.app.domain.Address;
import java.util.List;
import lombok.Data;

@Data
public class TrainingCenterDTO {

    private String centerCode;
    private String centerName;
    private Integer studentCapacity;
    private List<String> courseOffered;
    private String email;
    private String phone;
    private Address address;
}
