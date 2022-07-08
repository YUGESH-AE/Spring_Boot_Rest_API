package com.example.demo.CustomerService;

import com.example.demo.entity.Customer;
import com.example.demo.exception.NoSuchCustomer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Customer updateCustomer(Customer customer) throws NoSuchCustomer {
        Optional<Customer>optionalCustomer=customerRepository.findById(customer.getPhoneNo());
        if(optionalCustomer.isPresent()){
            Customer customer1=new Customer(customer.getPhoneNo(),
                    customer.getName(), customer.getAge(),
           customer.getGender(), customer.getAddress(), customer.getPlanId());
            customerRepository.save(customer1);
            return customer;
        }else {
            throw new NoSuchCustomer("No Such customer exist");
        }
    }

    public String deleteCustomer(Long phoneNo) throws NoSuchCustomer {
        Optional<Customer>optionalCustomer=customerRepository.findById(phoneNo);
        if(optionalCustomer.isPresent()){
            customerRepository.deleteById(phoneNo);
            return "Customer Deleted";
        }
        else {
            throw new NoSuchCustomer("No Such customer exist");
        }
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public ResponseEntity<Customer> findbyNameAndAge(String name, Integer age){
        Customer customer=customerRepository.findByNameAndAge(name,age);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
