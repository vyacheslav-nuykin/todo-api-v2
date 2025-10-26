package com.vyacheslav.todo_api.controllers;

import com.vyacheslav.todo_api.dto.request.TodoCreateRequest;
import com.vyacheslav.todo_api.dto.response.TodoResponse;
import com.vyacheslav.todo_api.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    @ResponseBody
    public List < TodoResponse > getAllTodosApi() {
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);
    }
}