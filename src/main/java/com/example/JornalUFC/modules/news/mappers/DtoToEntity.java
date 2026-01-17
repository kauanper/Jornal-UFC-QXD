package com.example.JornalUFC.modules.news.mappers;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DtoToEntity {

    public static News transform(NewsRegisterDTO dto, String publishedBy) {
        if (dto == null) {
            return null;
        }

        News news = new News();
        news.setTitle(dto.getTitle());
        news.setDescription(dto.getDescription());
        news.setCategory(dto.getCategory());
        news.setImagemUrl(dto.getImagemUrl());
        news.setText(dto.getText());
        news.setPublishedBy(publishedBy);
        news.setPublishedDate(LocalDateTime.now());

        return news;
    }
}
