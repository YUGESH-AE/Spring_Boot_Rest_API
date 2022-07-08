package com.example.demo.dto;

import com.example.demo.entity.Customer;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto implements Serializable {
    private Long phoneNo;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private Integer planId;

    public static Customer customerPrepare(CustomerDto customer){
        Customer customerDto=new Customer(customer.getPhoneNo(), customer.getName(),
                customer.getAge(), customer.getGender(), customer.getAddress(),
                customer.getPlanId());
        return customerDto;
    }
}
