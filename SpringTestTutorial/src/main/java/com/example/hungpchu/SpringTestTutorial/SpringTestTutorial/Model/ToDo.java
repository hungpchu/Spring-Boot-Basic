package com.example.hungpchu.SpringTestTutorial.SpringTestTutorial.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDo {
    private int id;
    public String title;
    public String detail;
}
