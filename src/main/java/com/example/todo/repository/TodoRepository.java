package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.entity.Todo;

//O Long é porque todo tem id do tipo Long
public interface TodoRepository extends JpaRepository<Todo, Long>{
  
}
