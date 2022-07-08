package com.example.demo.entity;

import com.example.demo.dto.CustomerDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private Long phoneNo;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private Integer planId;

    public static CustomerDto customerDtoPrepare(Customer customer){
        CustomerDto customerDto=new CustomerDto(customer.getPhoneNo(), customer.getName(),
                customer.getAge(), customer.getGender(), customer.getAddress(),
                customer.getPlanId());
        return customerDto;
    }
}