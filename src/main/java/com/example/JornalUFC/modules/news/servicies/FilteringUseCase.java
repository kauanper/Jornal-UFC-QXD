package com.example.JornalUFC.modules.news.servicies;

import com.example.JornalUFC.modules.news.Category;
import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.NewsRepository;
import com.example.JornalUFC.modules.news.OrderBy;
import com.example.JornalUFC.modules.news.dtos.NewsResponseDTO;
import com.example.JornalUFC.modules.news.mappers.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilteringUseCase {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsResponseDTO> execute(Category category, OrderBy orderBy) {

        List<News> newsList;
        if(category == null){
            newsList = newsRepository.findAll(); //vem por id, logo da mais antiga a mais recente
        }else {
            newsList = newsRepository.findByCategoryOrderByDateDesc(category); //ja vem ordenado

        }

        if(category != null && orderBy == OrderBy.ASC){ //antiga
            newsList = newsList.reversed();
        } else if (category == null && orderBy == OrderBy.DESC) {
            newsList = newsList.reversed();
        }

        List<NewsResponseDTO> newsResponseDTOList = new ArrayList<>();
        for (News news : newsList) {
            newsResponseDTOList.add(EntityToDto.transform(news));
        }
        return newsResponseDTOList;
    }
}
