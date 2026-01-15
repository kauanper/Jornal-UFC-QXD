package com.example.JornalUFC.modules.news.mappers;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DtoToEntity {

    /**
     * Converte um NewsRegisterDTO em News
     * @param dto DTO com os dados da notícia
     * @param publishedBy Nome ou ID do usuário que publicou a notícia
     * @return objeto News pronto para persistência
     */
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
