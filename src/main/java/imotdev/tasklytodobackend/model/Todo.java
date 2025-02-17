package imotdev.tasklytodobackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String title;
  private Boolean isCompleted;

  public Todo() {
  }

  public Todo(Long id, String title, Boolean isCompleted) {
    this.id = id;
    this.title = title;
    this.isCompleted = isCompleted;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getCompleted() {
    return isCompleted;
  }

  public void setCompleted(Boolean completed) {
    isCompleted = completed;
  }
}
