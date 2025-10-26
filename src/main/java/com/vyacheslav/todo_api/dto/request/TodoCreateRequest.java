package com.vyacheslav.todo_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCreateRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private boolean completed = false;
}
