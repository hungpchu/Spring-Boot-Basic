package com.example.hungpchu.ServiceAndRepository.Repository;

import com.example.hungpchu.ServiceAndRepository.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements RepositoryInterface{

    @Autowired
    Customer customer;

    @Override
    public Customer getCustomerByName(String name){
        customer.name = name;
        return customer;
    }
}
