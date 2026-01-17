package com.example.JornalUFC.modules.news.servicies;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.NewsRepository;
import com.example.JornalUFC.modules.news.dtos.NewsResponseDTO;
import com.example.JornalUFC.modules.news.mappers.EntityToDto;
import com.example.JornalUFC.shared.custonExceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetByIdUseCase {

    @Autowired
    private NewsRepository newsRepository;

    public NewsResponseDTO execute(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "id",
                                "Notícia não encontrada com id: " + id
                        )
                );
        return EntityToDto.transform(news);
    }
}
