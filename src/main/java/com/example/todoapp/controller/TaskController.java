package com.example.todoapp.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/changeStatus")
    String changeStatus(@RequestParam Integer id) {
        Task task = taskService.findById(id);
        taskService.updateStatus(task);
        return "redirect:/";
    }

    @GetMapping("/create")
    String create() {
        return "create";
    }

    @PostMapping("/create")
    String create(@Validated @ModelAttribute TaskForm taskForm, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        taskService.create(taskForm);
        return "redirect:/";
    }
}
