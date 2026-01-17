package com.example.JornalUFC.modules.news;

import com.example.JornalUFC.modules.news.dtos.CategoryDTO;
import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import com.example.JornalUFC.modules.news.dtos.NewsResponseDTO;
import com.example.JornalUFC.modules.news.servicies.*;
import com.example.JornalUFC.modules.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private CraeteNewsUseCase craeteNewsUseCase;

    @Autowired
    private GetByIdUseCase getByIdUseCase;

    @Autowired
    private GetAllNewsUseCase getAllNewsUseCase;

    @Autowired
    private DeleteNewsUseCase deleteNewsUseCase;

    @Autowired
    private UpdateNewsUseCase updateNewsUseCase;


    @PreAuthorize("hasRole('EDITOR')")
    @PostMapping
    public ResponseEntity<?> createNews(@RequestBody @Valid NewsRegisterDTO dto,
                                            Authentication authentication) {
        //pega o usuario logado e a partir dai, seu id
        User user = (User) authentication.getPrincipal();
        long userId = user.getId();

        NewsResponseDTO responseDTO  = craeteNewsUseCase.execute(userId, dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PreAuthorize("hasRole('EDITOR')")
    @DeleteMapping("/{newsId}")
    public ResponseEntity<?> deleteNews(@PathVariable long newsId) {
        deleteNewsUseCase.execute(newsId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('EDITOR')")
    @PutMapping("/{newsId}")
    public ResponseEntity<?> updateNews(@PathVariable long newsId,
                                        @RequestBody @Valid NewsRegisterDTO dto) {
        NewsResponseDTO responseDTO  = updateNewsUseCase.execute(newsId, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @PreAuthorize("hasRole('EDITOR')")
    @GetMapping("/orderBy/{order}")
    public ResponseEntity<List<NewsResponseDTO>> filters(
            @PathVariable OrderBy order,
            @RequestParam(required = false) Category category
    ) {
        return ResponseEntity.ok(List.of());
    }




    //rotas publicas------------------------------------------------------

    @GetMapping("/{newsId}")
    public ResponseEntity<NewsResponseDTO> getById(@PathVariable long newsId) {
        NewsResponseDTO responseDTO = getByIdUseCase.execute(newsId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<NewsResponseDTO>> getAll() {
        List<NewsResponseDTO> responseDTOList = getAllNewsUseCase.execute();
        return ResponseEntity.ok(responseDTOList);
    }


}
