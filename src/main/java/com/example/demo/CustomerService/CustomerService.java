package com.example.demo.CustomerService;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer insertCustomer(Customer customer){
        Customer customer1=customerRepository.save(customer);
        return customer1;
    }
    public Customer updateCustomer(Customer customer){
        Optional<Customer>optionalCustomer=customerRepository.findById(customer.getPhoneNo());
        if(optionalCustomer.isPresent()){
            Customer customer1=new Customer(customer.getPhoneNo(),
                    customer.getName(), customer.getAge(),
           customer.getGender(), customer.getAddress(), customer.getPlanId());
            customerRepository.save(customer1);
            return customer;
        }else {
            return null;
        }
    }

    public String deleteCustomer(Long phoneNo){
        Optional<Customer>optionalCustomer=customerRepository.findById(phoneNo);
        if(optionalCustomer.isPresent()){
            customerRepository.deleteById(phoneNo);
            return "Customer Deleted";
        }
        else {
            return "Customer not found";
        }
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer findbyNameAndAge(String name,Integer age){
        Customer customer=customerRepository.findByNameAndAge(name,age);
        return customer;
    }
}
