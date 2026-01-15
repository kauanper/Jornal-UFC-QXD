package com.example.JornalUFC.modules.news.dtos;

import com.example.JornalUFC.modules.news.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class NewsRegisterDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 150)
    private String title;

    @NotBlank(message = "A categoria é obrigatória")
    private Category category; // nova categoria adicionada

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, max = 255)
    private String description;

    @NotBlank(message = "A URL da imagem é obrigatória")
    @URL(message = "A imagem deve ser uma URL válida")
    private String imagemUrl;

    @NotBlank(message = "O texto da notícia é obrigatório")
    @Size(min = 10)
    private String text;

    // ===== Construtor sem argumentos =====
    public NewsRegisterDTO() {}

    // ===== Getters e Setters =====

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
