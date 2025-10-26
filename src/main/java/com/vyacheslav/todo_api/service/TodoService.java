package com.vyacheslav.todo_api.service;

import com.vyacheslav.todo_api.dto.request.TodoCreateRequest;
import com.vyacheslav.todo_api.dto.request.TodoUpdateRequest;
import com.vyacheslav.todo_api.dto.response.TodoResponse;
import com.vyacheslav.todo_api.models.Todo;
import com.vyacheslav.todo_api.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List < TodoResponse > getAllTodos() {
        return todoRepository.findAll().stream().map(
                todo -> new TodoResponse(
                        todo.getId(),
                        todo.getTitle(),
                        todo.isCompleted(),
                        todo.getCreatedAt()
                )
        ).toList();
    }

    @Transactional
    public TodoResponse createTodo(TodoCreateRequest request) {
        Todo todo = new Todo(request.getTitle(), request.isCompleted());
        Todo saved = todoRepository.save(todo);
        return new TodoResponse(
                saved.getId(),
                saved.getTitle(),
                saved.isCompleted(),
                saved.getCreatedAt()
        );
    }

    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Todo not found"));
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isCompleted(),
                todo.getCreatedAt()
        );
    }

    @Transactional
    public TodoResponse updateTitle(Long id, TodoUpdateRequest request) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Todo not found"));

        String title = request.getTitle();
        if (title == null || title.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Title must not be empty");
        }
        todo.setTitle(title.trim());

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isCompleted(),
                todo.getCreatedAt()
        );
    }

    @Transactional
    public TodoResponse markAsCompleted(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));

        todo.setCompleted(true);
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isCompleted(),
                todo.getCreatedAt()
        );
    }
}