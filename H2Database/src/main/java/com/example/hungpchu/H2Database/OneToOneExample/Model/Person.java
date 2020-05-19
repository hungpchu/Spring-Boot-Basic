package com.example.hungpchu.H2Database.OneToOneExample.Model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Person { // table Person

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
