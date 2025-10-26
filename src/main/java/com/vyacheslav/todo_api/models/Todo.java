package com.vyacheslav.todo_api.models;

import java.time.LocalDateTime;

public class Todo {
    private Long id;
    private String title;
    private boolean completed = false;
    private LocalDateTime createdAt;

    public Todo() {}

    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Boolean isCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
