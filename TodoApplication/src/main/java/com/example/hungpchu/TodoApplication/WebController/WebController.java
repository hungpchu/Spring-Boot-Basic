package com.example.hungpchu.TodoApplication.WebController;

import com.example.hungpchu.TodoApplication.Model.ToDo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class WebController {


    List<ToDo> list = new CopyOnWriteArrayList<>();

    /**
     *
     * @param model
     * @param limit
     * @return the html page with the list of ToDo object
     */
    @GetMapping(value="/listToDo")
    public String listToDo(Model model, @RequestParam(value="limit", required = false) Integer limit)
    {
        model.addAttribute("list", limit != null ? list.subList(0,limit) : list);
        return "listToDo";
    }

    /**
     *
     * @param model
     * @return html page with adding the task and detail property for the ToDo Object
     */
    @GetMapping(value="/addToDo")
    public String addToDo(Model model)
    {
        model.addAttribute("newTask", new ToDo());
        return "addToDo";
    }

    /**
     *
     * @param todo
     * @return a html page with success word and view the list option
     */
    @PostMapping(value="/addToDo")
    public String addToDo(@ModelAttribute ToDo todo)
    {
        list.add(todo);
        return "success";
    }

}
