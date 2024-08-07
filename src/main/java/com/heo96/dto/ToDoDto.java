package com.heo96.dto;

import lombok.*;

public class ToDoDto {
    private String question;
    private String status;

    public String getQuestion() {
        return question;
    }

    public String getStatus() {
        return status;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
