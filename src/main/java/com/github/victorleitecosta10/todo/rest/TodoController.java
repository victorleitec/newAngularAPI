package com.github.victorleitecosta10.todo.rest;

import com.github.victorleitecosta10.todo.model.Todo;
import com.github.victorleitecosta10.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @PostMapping
    public Todo save(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PatchMapping("{id}/done")
    public Todo markAsDone(@PathVariable Long id) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setDone(true);
                    todo.setDoneDate(now());
                    repository.save(todo);
                    return todo;
                }).orElseThrow(null);
    }
}
