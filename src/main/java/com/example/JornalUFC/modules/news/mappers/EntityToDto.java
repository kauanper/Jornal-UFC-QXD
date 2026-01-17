package com.example.JornalUFC.modules.news.mappers;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.dtos.NewsResponseDTO;

public class EntityToDto {

    public static NewsResponseDTO transform(News news) {
        if (news == null) {
            return null;
        }

        return new NewsResponseDTO(
                news.getId(),
                news.getTitle(),
                news.getDescription(),
                news.getCategory(),
                news.getImagemUrl(),
                news.getText(),
                news.getPublishedBy(),
                news.getPublishedDate()
        );
    }
}
