package com.example.hungpchu.H2Database.OneToOneExample.Model;

import lombok.Data;
import lombok.Builder;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Data
@Builder
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String province;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
