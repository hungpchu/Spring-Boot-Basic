package com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Repository;

import com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    List<ToDo> findAll();
    ToDo findById(int id);
}
