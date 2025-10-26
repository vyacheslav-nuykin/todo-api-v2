package com.vyacheslav.todo_api.repository;

import com.vyacheslav.todo_api.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {}
