package com.example.JornalUFC.modules.news.dtos;

import com.example.JornalUFC.modules.news.Category;
import java.time.LocalDateTime;

public record NewsResponseDTO(
        long id,
        String title,
        String description,
        Category category,
        String imagemUrl,
        String text,
        String publishedBy,
        LocalDateTime publishedDate
) { }
