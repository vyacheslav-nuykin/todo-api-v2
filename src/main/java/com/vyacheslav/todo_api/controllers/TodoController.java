package com.vyacheslav.todo_api.controllers;

import com.vyacheslav.todo_api.models.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong currentId = new AtomicLong(1);

    @GetMapping
    public List<Todo> getAllTodos() {
        return todos;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title is required and cannot be empty");
        }
        task.setCompleted(false);
        task.setId(currentId.getAndIncrement());
        task.setCreatedAt(java.time.LocalDateTime.now());
        todos.add(task);

        return task;
    }

    @GetMapping("/{id}")
    public Todo getTaskById(@PathVariable Long id) {
        return todos.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo with id=" + id + " not found"));
    }

    @PatchMapping("/{id}/complete")
    public Todo setCompleteTaskStateById(@PathVariable Long id) {
        Todo task = todos.stream()
                    .filter(n -> n.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo with id=" + id + " not found"));
        task.setCompleted(true);

        return task;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        Todo taskToDelete = todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));
        todos.remove(taskToDelete);

        return ResponseEntity.noContent().build();
    }
}
