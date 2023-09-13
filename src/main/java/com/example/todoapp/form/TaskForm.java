package com.example.todoapp.form;

import java.time.LocalDate;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class TaskForm {
    private Integer id;
    private Integer status;
    @NotBlank
    private String title;
    @NotNull
    private LocalDate deadline;
}
