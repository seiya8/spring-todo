package com.example.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressapp.model.Task;


public interface TaskRepository extends JpaRepository<Customer, Integer> {
}
