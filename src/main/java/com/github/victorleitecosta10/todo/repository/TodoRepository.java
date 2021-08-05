package com.github.victorleitecosta10.todo.repository;

import com.github.victorleitecosta10.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
