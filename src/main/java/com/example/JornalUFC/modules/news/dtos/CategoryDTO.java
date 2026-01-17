package com.example.JornalUFC.modules.news.dtos;

import com.example.JornalUFC.modules.news.Category;
import jakarta.validation.constraints.NotNull;

public record CategoryDTO(
        @NotNull(message = "A categoria é obrigatória")
        Category category
) {
}
