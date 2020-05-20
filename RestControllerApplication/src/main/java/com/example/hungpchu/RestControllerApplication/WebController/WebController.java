package com.example.hungpchu.RestControllerApplication.WebController;

import com.example.hungpchu.RestControllerApplication.Model.ToDo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1")
public class WebController {
    private List<ToDo> list;

    @PostConstruct
    public void init()
    {
        list = IntStream.range(0,10).mapToObj(i -> new ToDo("title-" + i, "detail-" + i)).collect(Collectors.toList());
    }

    @GetMapping("/list")
    public List<ToDo> getList()
    {
        return list;
    }

    @GetMapping("/list/{todoID}")
    public ToDo getID(@PathVariable(name="todoID") Integer todoID)
    {
        System.out.println("todo = "+ list.get(todoID));
        return list.get(todoID);
    }

    @PostMapping("/list/addToDo")
    public ResponseEntity addToDo(@RequestBody ToDo todo)
    {
        list.add(todo);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.ok().body(todo);
    }

    @PutMapping("/list/update/{todoID}")
    public ToDo updateToDo(@PathVariable(name="todoID") Integer todoID, @RequestBody ToDo todo)
    {
        list.set(todoID,todo);
        return todo;
    }

    @DeleteMapping("/list/delete/{todoID}")
    public ResponseEntity deleteToDo(@PathVariable(name="todoID") int todoID)
    {
        list.remove(todoID);
        return ResponseEntity.ok().build();
    }

}
