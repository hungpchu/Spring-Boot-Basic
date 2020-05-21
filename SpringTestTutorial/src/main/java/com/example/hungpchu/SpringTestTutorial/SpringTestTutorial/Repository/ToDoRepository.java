package com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Repository;

import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository {
    List<ToDo> findAll();
    ToDo findById(int id);
}
