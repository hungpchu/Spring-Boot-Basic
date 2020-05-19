package com.example.hungpchu.H2Database.OneToManyExample.Model;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Book> books;



}
