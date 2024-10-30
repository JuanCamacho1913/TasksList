package com.example.taskList.presentation.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TaskRequest(

        //@NotBlank(message = "Task description is mandatory")
        String description,
        //@NotBlank(message = "Task date is mandatory")
        LocalDate date,
        //@NotBlank(message = "Task limit date is mandatory")
        LocalDate limitDate,
        //@NotBlank(message = "Task finished is mandatory")
        Boolean finished
) {
}
