package com.example.JornalUFC.modules.news.servicies;

import com.example.JornalUFC.modules.news.News;
import com.example.JornalUFC.modules.news.NewsRepository;
import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import com.example.JornalUFC.modules.news.mappers.DtoToEntity;
import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CraeteNewsUseCase {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UserRepository userRepository;

    public void execute(long id, NewsRegisterDTO newsRegisterDTO) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
        String publisherBy = user.getNickname();

        News news = DtoToEntity.transform(newsRegisterDTO, publisherBy);

        newsRepository.save(news);
    }
}
