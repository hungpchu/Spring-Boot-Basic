package com.example.hungpchu.H2Database.Repository;

import com.example.hungpchu.H2Database.ManyToMany.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
