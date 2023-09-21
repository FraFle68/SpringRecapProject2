package com.example.backend;

import lombok.With;

public record KanbanEntry(
        String id,

        String description,
        @With
        Status status
) {
}