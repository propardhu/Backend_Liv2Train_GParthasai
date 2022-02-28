package com.liv2train.app.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "training_center")
public class TrainingCenter implements Serializable {

    @Id
    @Field("center_code")
    @Pattern(message = "invalid centerCode", regexp = "^[A-Za-z0-9]+${12}")
    private String centerCode;

    @Field("center_name")
    private String centerName;

    @Field("student_capacity")
    private Integer studentCapacity;

    @Field("course_offered")
    private List<String> courseOffered;

    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email cannot be empty")
    @Field("email")
    private String email;

    @Field("phone")
    @Pattern(message = "invalid phoneNumber", regexp = "(^$|[0-9]{10})")
    private String phone;

    @Field("address")
    private Address address;

    @CreatedDate
    private Instant created;

    @LastModifiedDate
    private Instant modified;
}
