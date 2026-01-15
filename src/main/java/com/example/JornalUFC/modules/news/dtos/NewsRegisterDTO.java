package com.example.JornalUFC.modules.news.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class NewsRegisterDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 150)
    private String title;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, max = 255)
    private String description;

    @NotBlank(message = "A URL da imagem é obrigatória")
    @URL(message = "A imagem deve ser uma URL válida")
    private String imagemUrl;

    @NotBlank(message = "O texto da notícia é obrigatório")
    @Size(min = 10)
    private String text;

    public NewsRegisterDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

