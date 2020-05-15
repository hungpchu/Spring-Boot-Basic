package com.example.hungpchu.ServiceAndRepository.Repository;

import com.example.hungpchu.ServiceAndRepository.Model.Customer;

public interface RepositoryInterface {
    Customer getCustomerByName(String name);
}
