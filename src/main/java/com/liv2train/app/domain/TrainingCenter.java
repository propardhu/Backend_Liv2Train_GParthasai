package com.liv2train.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "training_center")
public class TrainingCenter implements Serializable {

    @Id
    @Field("center_code")
    @JsonProperty("CenterCode")
    @Pattern(regexp = "^[A-Za-z0-9]+${12}")
    private String centerCode;

    @Field("center_name")
    private String centerName;

    @Field("student_capacity")
    private Integer studentCapacity;

    @Field("course_offered")
    private List<String> courseOffered;

    @Email(
        message = "Email is not valid",
        regexp = "{(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])}"
    )
    @NotEmpty(message = "Email cannot be empty")
    @Field("email")
    private String email;

    @Field("phone")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

    @Field("address")
    private Address address;
}
