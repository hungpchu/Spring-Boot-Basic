package com.example.hungpchu.SwaggerTutorial.WebController;

import com.example.hungpchu.SwaggerTutorial.Model.User;
import com.example.hungpchu.SwaggerTutorial.Repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@Api(value = "User Apis")
public class WebController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "Watch the list of User", response = List.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not Authenticated"),
            @ApiResponse(code = 403, message = "Forbidden Access"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){ return userRepository.findById(id).orElseGet((Supplier<? extends User>) new User()); }

    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user)
    {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id){ userRepository.deleteById(id);}


}
