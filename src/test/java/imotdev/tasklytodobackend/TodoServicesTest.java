package imotdev.tasklytodobackend;

import imotdev.tasklytodobackend.model.Todo;
import imotdev.tasklytodobackend.repository.TodoRepository;
import imotdev.tasklytodobackend.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServicesTest {

  @Mock
  private TodoRepository todoRepository;

  @InjectMocks
  private TodoService todoService;

  @BeforeEach
  void setUp() {
    Mockito.reset(todoRepository);
  }

  @Test
  void testGetAllTodos(){
    Todo todo1 = new Todo(1L, "Belajar Mengaji", false);
    Todo todo2 = new Todo(2L, "Bellajar Javaspring", false);

    when(todoRepository.findAll()).thenReturn(Arrays.asList(todo1, todo2));

    List<Todo> todos = todoService.getAllTodos();

    assertEquals(2, todos.size());
    assertEquals("Belajar Mengaji", todos.get(0).getTitle());
    verify(todoRepository, times(1)).findAll();
  }
}
