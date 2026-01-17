package com.example.JornalUFC.modules.news.servicies;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.NewsRepository;
import com.example.JornalUFC.shared.custonExceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeleteNewsUseCase {

    @Autowired
    private NewsRepository newsRepository;

    public void execute(Long newsId) {

        if (!newsRepository.existsById(newsId)) {
            throw new ResourceNotFoundException(
                    "id",
                    "Notícia não encontrada com id: " + newsId
            );
        }

        newsRepository.deleteById(newsId);
    }


}
