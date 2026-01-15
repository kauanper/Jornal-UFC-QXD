package com.example.JornalUFC.modules.news;

import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import com.example.JornalUFC.modules.news.dtos.NewsResponseDTO;
import com.example.JornalUFC.modules.news.servicies.CraeteNewsUseCase;
import com.example.JornalUFC.modules.news.servicies.GetByIdUseCase;
import com.example.JornalUFC.modules.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private CraeteNewsUseCase craeteNewsUseCase;
    @Autowired
    private GetByIdUseCase getByIdUseCase;

    @PreAuthorize("hasRole('EDITOR')")
    @PostMapping
    public ResponseEntity<?> createNews(@RequestBody @Valid NewsRegisterDTO dto,
                                            Authentication authentication) {
        //pega o usuario logado e a partir dai, seu id
        User user = (User) authentication.getPrincipal();
        long userId = user.getId();

        NewsResponseDTO responseDTO  = craeteNewsUseCase.execute(userId, dto);

        return ResponseEntity.ok(responseDTO);
    }

    //não possi retrição de user
    @GetMapping("/{newsId}")
    public ResponseEntity<NewsResponseDTO> getById(@PathVariable long newsId) {
        NewsResponseDTO responseDTO = getByIdUseCase.execute(newsId);
        return ResponseEntity.ok(responseDTO);
    }




}
