package com.example.todoapp.form;

import java.time.LocalDateTime;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;


@Data
public class CustomerForm {
    private Integer id;
    @NotBlank
    private Int status;
    @NotBlank
    private String title;
    @NotBlank
    private LocalDateTime deadline;
}
