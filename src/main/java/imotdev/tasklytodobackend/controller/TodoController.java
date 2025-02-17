package imotdev.tasklytodobackend.controller;

import imotdev.tasklytodobackend.model.Todo;
import imotdev.tasklytodobackend.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
  private TodoService todoService;

  @GetMapping
  public List<Todo> getAllTodos(){
    return todoService.getAllTodos();
  }

  @PostMapping
  public Todo createTodo(@RequestBody Todo todo){
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
