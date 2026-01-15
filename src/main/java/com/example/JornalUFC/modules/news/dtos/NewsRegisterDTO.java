package com.example.JornalUFC.modules.news.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
@Data
public class NewsRegisterDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 150, message = "O título deve ter entre 5 e 150 caracteres")
    private String title;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, max = 255, message = "A descrição deve ter entre 10 e 255 caracteres")
    private String description;

    @NotBlank(message = "A URL da imagem é obrigatória")
    @URL(message = "A imagem deve ser uma URL válida")
    private String imagemUrl;

    @NotBlank(message = "O texto da notícia é obrigatório")
    @Size(min = 10, message = "O texto deve ter no mínimo 10 caracteres")
    private String text;

}
