package com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Service;

import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Model.ToDo;
import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Repository.ToDoRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Cách 1: test với @SpringBootTest -> thích hợp cho integration test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {
    @MockBean
    ToDoRepository toDoRepository;

    @Autowired
    private ToDoService toDoService;


    @Before
    public void setUp()
    {
        Mockito.when(toDoRepository.findAll()).thenReturn((List<ToDo>) IntStream.range(0, 10)
                .mapToObj(i -> new ToDo(i, "title-" + i, "detail-" + i))
                .collect(Collectors.toList()));
    }

    @Test
    public void testCount()
    {
        Assert.assertEquals(10,toDoService.countTodo());
    }


}
