package com.example.hungpchu.H2Database.ManyToMany;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Data
@Builder
public class Teacher {
    @Id
    @GeneratedValue
    private Integer id;

    public String name;

    @ManyToMany(mappedBy = "teachers")
    @EqualsAndHashCode.Exclude
    public Collection<Student> students;
}
