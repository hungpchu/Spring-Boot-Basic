package com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Controller;

import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Model.ToDo;
import com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Service.ToDoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    public void TestFindAll() throws Exception{
        List<ToDo> allToDos  = IntStream.range(0,10).mapToObj(i -> new ToDo(i, "title-" + i, "detail-"+i)).collect(Collectors.toList());

        given(toDoService.getAll()).willReturn(allToDos);

        mockMvc.perform(get("/api/v1/todo").contentType(MediaType.APPLICATION_JSON)) // Thực hiện GET REQUEST
                .andExpect(status().isOk()) // Mong muốn Server trả về status 200
                .andExpect(jsonPath("$", hasSize(10))) // Hi vọng server trả về List độ dài 10
                .andExpect(jsonPath("$[0].id", is(0))) // Hi vọng phần tử trả về đầu tiên có id = 0
                .andExpect(jsonPath("$[0].title", is("title-0"))) // Hi vọng phần tử trả về đầu tiên có title = "title-0"
                .andExpect(jsonPath("$[0].detail", is("detail-0")));
    }
}
