package com.example.hungpchu.ToDoApplicationWithDataBase.Service;

import com.example.hungpchu.ToDoApplicationWithDataBase.Model.ToDo;
import com.example.hungpchu.ToDoApplicationWithDataBase.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {

    @Autowired
    public ToDoRepository toDoRepository;

    public List<ToDo> findAll()
    {
        return toDoRepository.findAll();
    }

    public ToDo add(ToDo todo)
    {
        ToDo task = toDoRepository.save(todo);
        return task;
    }

    public void delete(String key)
    {
         toDoRepository.deleteAllShit(key);
    }
}
