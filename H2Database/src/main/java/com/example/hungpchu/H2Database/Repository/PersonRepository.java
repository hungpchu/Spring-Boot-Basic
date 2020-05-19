package com.example.hungpchu.H2Database.Repository;

import com.example.hungpchu.H2Database.OneToOneExample.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}