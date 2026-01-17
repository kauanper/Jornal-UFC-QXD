package com.example.JornalUFC.modules.news.servicies;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.NewsRepository;
import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import com.example.JornalUFC.modules.news.dtos.NewsResponseDTO;
import com.example.JornalUFC.modules.news.mappers.EntityToDto;
import com.example.JornalUFC.shared.custonExceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateNewsUseCase {

    @Autowired
    private NewsRepository newsRepository;

    public NewsResponseDTO execute(Long newsId, NewsRegisterDTO dto){

        News news = newsRepository.findById(newsId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "id",
                                "Notícia não encontrada com id: " + newsId
                        )
                );
        /*
        nao estou mexendo nos campos de PublishedBy e PublishedDate, confirmar com o grupo dps
        */

        news.setTitle(dto.getTitle());
        news.setCategory(dto.getCategory());
        news.setDescription(dto.getDescription());
        news.setImagemUrl(dto.getImagemUrl());
        news.setText(dto.getText());

        newsRepository.save(news);

        return EntityToDto.transform(news);
    }
}
