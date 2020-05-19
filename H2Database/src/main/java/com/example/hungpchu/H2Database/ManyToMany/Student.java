package com.example.hungpchu.H2Database.ManyToMany;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    public String name;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "student_teacher",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name="teacher_id"))
    public Collection<Teacher> teachers;
}
