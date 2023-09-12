package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;

import com.example.todoapp.model.Task;
import com.example.todoapp.repository.TaskRepository;
import com.example.todoapp.service.TaskService;
import com.example.todoapp.form.TaskForm;


@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/")
    String index(Model model) {
        List<Task> tasks = taskService.getAll();
        tasks.forEach(task -> {
            if (task.getStatus() == 0) {
                task.setStatusStr("未完了");
            } else {
                task.setStatusStr("完了");
            }
        });
        model.addAttribute("tasks", tasks);
        return "index";
    }
}
