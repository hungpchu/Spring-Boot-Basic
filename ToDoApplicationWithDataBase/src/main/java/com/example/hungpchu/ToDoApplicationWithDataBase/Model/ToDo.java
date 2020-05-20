package com.example.hungpchu.ToDoApplicationWithDataBase.Model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class ToDo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public String title;
    public String detail;

}
