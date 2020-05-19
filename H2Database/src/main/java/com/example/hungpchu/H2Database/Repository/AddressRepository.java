package com.example.hungpchu.H2Database.Repository;

import com.example.hungpchu.H2Database.OneToOneExample.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}

