package com.example.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todoapp.model.Task;
import com.example.todoapp.form.TaskForm;
import com.example.todoapp.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    public Task findById(Integer id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public void updateStatus(Task task) {
        task.setStatus(1);
        taskRepository.save(task);
    }

    public void create(TaskForm taskForm) {
        Task task = new Task();
        task.setTitle(taskForm.getTitle());
        task.setDeadline(taskForm.getDeadline());
        taskRepository.save(task);
    }
}