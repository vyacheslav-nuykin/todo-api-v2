package com.vyacheslav.todo_api.controllers;

import com.vyacheslav.todo_api.dto.request.TodoCreateRequest;
import com.vyacheslav.todo_api.dto.request.TodoUpdateRequest;
import com.vyacheslav.todo_api.dto.response.TodoResponse;
import com.vyacheslav.todo_api.models.Todo;
import com.vyacheslav.todo_api.service.TodoService;
import jakarta.validation.Valid;
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

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    @ResponseBody
    public List<TodoResponse> getAllTodosApi() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public TodoResponse createTodo(@Valid @RequestBody TodoCreateRequest task) {
        return todoService.createTodo(task);
    }

    @GetMapping("/{id}")
    public TodoResponse getTaskById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PatchMapping("/{id}/complete")
    public TodoResponse setCompleteTaskStateById(@PathVariable Long id) {
        return todoService.markAsCompleted(id);
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
