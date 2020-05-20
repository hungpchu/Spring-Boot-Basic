package com.example.hungpchu.ToDoApplicationWithDataBase.WebController;

import com.example.hungpchu.ToDoApplicationWithDataBase.Model.ToDo;
import com.example.hungpchu.ToDoApplicationWithDataBase.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class WebController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/")
    public String index()
    {
        return "index";
    }


    @GetMapping(value = "/listToDo")
    public String listToDo(Model model)
    {
        List<ToDo> list = todoService.findAll();
        model.addAttribute("list",list);
        return "listToDo";
    }

    /**
     * Controller map here when user want to get this page
     * @param model
     * @return
     */
    @GetMapping(value="/addToList")
    public String addToList(Model model)
    {
        model.addAttribute("newTask", new ToDo());
        return "addToList";
    }


    /**
     * Controller map here after click submit form with post method
     * @param todo
     * @return
     */
    @PostMapping(value= "/addToList")
    public String success(@ModelAttribute ToDo todo)
    {
        todoService.add(todo);
        return "success";
    }

    @GetMapping("/deleteTask")
    public String delete(){  return "deleteTask";  }


    /**
     * @RequestParam helps get the deleteKey in the html
     * @param deleteKey
     * @return
     */
    @PostMapping("/deleteTask")
    public String delete(@RequestParam String deleteKey){
        todoService.delete(deleteKey);
        return "success";
    }
}
