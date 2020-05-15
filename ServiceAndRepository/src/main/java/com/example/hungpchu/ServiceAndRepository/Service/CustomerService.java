package com.example.hungpchu.ServiceAndRepository.Service;

import com.example.hungpchu.ServiceAndRepository.Model.Customer;
import com.example.hungpchu.ServiceAndRepository.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getRandomCustomerByName()
    {
        String name = randomCustomerName(5);
        return customerRepository.getCustomerByName(name);
    }

    public String randomCustomerName(int length){

        String res = "";
        Random rand = new Random();
        char[] w = {'a','b','c','d','e'};
        for ( int i = 0; i < length; i++){
            int num = rand.nextInt(5);
            res = res + w[num];
        }
        return res;
    }
}
