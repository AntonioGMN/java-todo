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
  private boolean finish;
  private int priority;

  public Todo() {}

  public Todo(@NotBlank String name, @NotBlank String description, boolean finish, int priority) {
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
}
