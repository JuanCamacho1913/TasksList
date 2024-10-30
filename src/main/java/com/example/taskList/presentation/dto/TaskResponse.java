package com.example.taskList.presentation.dto;

import java.time.LocalDate;

public record TaskResponse(
        Long id,
        String description,
        LocalDate date,
        LocalDate limitDate,
        Boolean finished
) {
}
