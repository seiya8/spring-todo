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
        tasks.forEach(task -> {
            task.setStatusStr(convertStatusToString(task.getStatus()));
        });
        return tasks;
    }

    private String convertStatusToString(int status) {
        return (status == 0) ? "未完了" : "完了";
    }

    public Task findById(Integer id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public void updateStatus(Task task) {
        task.setStatus(1);
        taskRepository.save(task);
    }
}