package com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Model.ToDo;
import com.example.hungpchu.SpringTestTutorial.SpringTestDataSetTutorial.Repository.ToDoRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaAnnotationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ToDoRepository todoRepository;

    @Test
    public void allComponentAreNotNull()
    {
        Assertions.assertThat(dataSource).isNotNull();
        Assertions.assertThat(jdbcTemplate).isNotNull();
        Assertions.assertThat(entityManager).isNotNull();
        Assertions.assertThat(todoRepository).isNotNull();

    }

    @Test
    public void testTodoRepositoryByCode() {
        todoRepository.save(new ToDo(0, "Todo-1", "Detail-1"));
        todoRepository.save(new ToDo(0, "Todo-2", "Detail-2"));

        Assertions.assertThat(todoRepository.findAll()).hasSize(2);
        Assertions.assertThat(todoRepository.findById(1).getTitle()).isEqualTo("Todo-1");
    }

    @After
    public void clean() {
        todoRepository.deleteAll();
    }
}
