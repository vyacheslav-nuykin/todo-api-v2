package com.vyacheslav.todo_api.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TodoResponse {

    private Long id;
    private String title;
    private boolean completed = false;
    private LocalDateTime createdAt;

    public TodoResponse(Long id, String title, boolean completed, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
    }
}
