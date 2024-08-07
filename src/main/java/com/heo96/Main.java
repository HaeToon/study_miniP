package com.heo96;

import com.heo96.service.ToDoService;

public class Main {
    public static void main(String[] args) {
        ToDoService toDoService = new ToDoService();
        toDoService.run();
    }
}