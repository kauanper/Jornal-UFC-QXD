package com.example.JornalUFC.modules.news.servicies;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.NewsRepository;
import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CraeteNewsUseCase {

    @Autowired
    private NewsRepository newsRepository;

    public void execute(long id, NewsRegisterDTO newsRegisterDTO) {



    }
}
