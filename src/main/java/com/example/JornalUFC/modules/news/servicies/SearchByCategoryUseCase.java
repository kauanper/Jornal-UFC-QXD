package com.example.JornalUFC.modules.news.servicies;

import com.example.JornalUFC.modules.news.Category;
import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.NewsRepository;
import com.example.JornalUFC.modules.news.dtos.CategoryDTO;
import com.example.JornalUFC.modules.news.dtos.NewsResponseDTO;
import com.example.JornalUFC.modules.news.mappers.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchByCategoryUseCase {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsResponseDTO> execute(CategoryDTO dto) {
        Category category = dto.category();
        List<News> newsList = newsRepository.findByCategoryOrderByDateDesc(category);
        List<NewsResponseDTO> newsResponseDTOList = new ArrayList<>();
        for (News news : newsList) {
            newsResponseDTOList.add(EntityToDto.transform(news));
        }
        return newsResponseDTOList;
    }
}
