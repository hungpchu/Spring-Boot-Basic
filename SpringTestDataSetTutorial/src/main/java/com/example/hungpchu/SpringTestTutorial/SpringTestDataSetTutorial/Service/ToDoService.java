package com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Service;

import com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Model.ToDo;
import com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public List<ToDo> getAll(){ return toDoRepository.findAll(); }
}
