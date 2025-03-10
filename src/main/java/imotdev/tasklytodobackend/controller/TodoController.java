package imotdev.tasklytodobackend.controller;

import imotdev.tasklytodobackend.model.Todo;
import imotdev.tasklytodobackend.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todos")

public class TodoController {
  @Autowired
  private TodoService todoService;

  @GetMapping
  public List<Todo> getAllTodos() {
    return todoService.getAllTodos();
  }

  @PostMapping
  public Todo createTodo(@RequestBody Todo todo) {
    log.info("todo create: {}", todo);
    return todoService.createTodo(todo);
  }

  @PutMapping("/{id}")
  public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
    return todoService.updateTodo(id, todo);
  }

  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
  }

}
