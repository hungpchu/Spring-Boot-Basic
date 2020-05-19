package com.example.hungpchu.H2Database.Repository;

import com.example.hungpchu.H2Database.ManyToMany.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
