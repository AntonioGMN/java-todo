package com.example.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todos")
public class Todo {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank
  private String name;
    
  @NotBlank
  private String description;
    
  @NotBlank
  private boolean finish;

  @NotBlank
  private int priority;
  
  public Todo(String name, String description, boolean finish, int priority) {
    this.name = name;
    this.description = description;
    this.finish = finish;
    this.priority = priority;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isFinish() {
    return finish;
  }

  public int getPriority() {
    return priority;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setFinish(boolean finish) {
    this.finish = finish;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }
}
