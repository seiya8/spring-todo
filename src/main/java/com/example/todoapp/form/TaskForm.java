package com.example.todoapp.form;

import java.time.LocalDate;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;


@Data
public class TaskForm {
    private Integer id;
    @NotBlank
    private Integer status;
    @NotBlank
    private String title;
    @NotBlank
    private LocalDate deadline;
}
