package imotdev.tasklytodobackend.controller;

import imotdev.tasklytodobackend.model.Todo;
import imotdev.tasklytodobackend.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todos")

public class TodoController {
  @Autowired
  private TodoService todoService;

  @GetMapping
  public ResponseEntity<?> getAllTodos() {
    try {
      List<Todo> todos = todoService.getAllTodos();

      if(todos.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Tidak ada data todo.");
      }
      return ResponseEntity.ok(todos);
    }catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Terjadi kesalahan saat mengambil data: " + e.getMessage());
    }
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
