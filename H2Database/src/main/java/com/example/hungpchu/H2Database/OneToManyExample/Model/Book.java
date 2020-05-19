package com.example.hungpchu.H2Database.OneToManyExample.Model;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Integer id;


    public String title;

    @ManyToOne
    @JoinColumn(name="author_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    public Author author;
}
