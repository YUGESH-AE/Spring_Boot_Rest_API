package com.example.demo.entity;



import com.example.demo.utility.CommonMethods;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @NotNull @Pattern(regexp = "[0-9]{10}",message = CommonMethods.phone)
    private Long phoneNo;
    @NotNull @Pattern(regexp = "^[0-9]",message = CommonMethods.name)
    private String name;
    @NotNull @Pattern(regexp = "[0-9]{2}",message = CommonMethods.age)
    private Integer age;
    @NotNull @Pattern(regexp = "[a-z,A-Z]{1}",message = CommonMethods.age)
    private Character gender;
    private String address;
    @NotNull @Pattern(regexp = "[0-9]{1}",message = CommonMethods.planId)
    private Integer planId;


}