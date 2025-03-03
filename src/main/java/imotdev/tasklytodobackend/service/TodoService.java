package imotdev.tasklytodobackend.service;

import imotdev.tasklytodobackend.model.Todo;
import imotdev.tasklytodobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
  @Autowired
  private TodoRepository todoRepository;

  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }

  public Todo createTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  public Todo updateTodo(Long id, Todo updatedTodo) {
    return todoRepository.findById(id)
            .map(todo -> {
              todo.setTitle(updatedTodo.getTitle());
              todo.setIsCompleted(updatedTodo.getIsCompleted());
              return todoRepository.save(todo);
            })
            .orElseThrow(() -> new RuntimeException("Todo not found"));
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }
}
