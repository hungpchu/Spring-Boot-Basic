package com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Service;

import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Model.ToDo;
import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todoRepository;

    public int countTodo(){
        return todoRepository.findAll().size();
    }

    public ToDo getTodo(int id){
        return todoRepository.findById(id);
    }

    public List<ToDo> getAll(){
        return todoRepository.findAll();
    }
}
