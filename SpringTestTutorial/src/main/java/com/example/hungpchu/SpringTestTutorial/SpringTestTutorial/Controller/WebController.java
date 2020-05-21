package com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Controller;

import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Model.ToDo;
import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WebController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todo")
    public List<ToDo> findAll(){ return toDoService.getAll(); }

}
