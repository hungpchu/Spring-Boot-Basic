package com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial;

import com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Repository.ToDoRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SqlAnnotationtest {
    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    @Sql("/createToDo.sql")
    public void testTodoRepositoryBySqlSchema()
    {

        Assertions.assertThat(toDoRepository.findAll()).hasSize(2);
        Assertions.assertThat(toDoRepository.findById(1).getTitle()).isEqualTo("Todo-1");
    }
}
