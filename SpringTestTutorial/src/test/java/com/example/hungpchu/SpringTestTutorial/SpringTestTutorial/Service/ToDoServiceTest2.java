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
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Cách 2: test với @TestConfiguration -> thích hợp cho unit test
 */
@RunWith(SpringRunner.class)
public class ToDoServiceTest2 {

    @TestConfiguration
    public static class ToDoServiceTestConfiguration{

        @Bean
        ToDoService toDoService()
        {
            return new ToDoService();
        }
    }

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
