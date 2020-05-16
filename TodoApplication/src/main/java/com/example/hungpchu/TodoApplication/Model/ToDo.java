package com.example.hungpchu.TodoApplication.Model;

import org.springframework.stereotype.Component;

/**
 * Always need to have get and set method since
 * Spring will detect easier
 */
public class ToDo {
    public String task;
    public String detail;

    public String getTask(){ return this.task; }
    public String getDetail(){ return this.detail; }
    public void setTask(String task){ this.task = task; }
    public void setDetail(String detail){ this.detail = detail; }
}
