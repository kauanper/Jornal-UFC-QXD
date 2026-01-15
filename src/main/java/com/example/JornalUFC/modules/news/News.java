package com.example.JornalUFC.modules.news;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "News")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String imagemUrl;
    private String text;
    private String publishedBy;
    private LocalDateTime publishedDate;

    // ===== Construtores =====

    public News() {
        // NoArgsConstructor
    }

    public News(long id, String title, String description, Category category,
                String imagemUrl, String text, String publishedBy, LocalDateTime publishedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.imagemUrl = imagemUrl;
        this.text = text;
        this.publishedBy = publishedBy;
        this.publishedDate = publishedDate;
    }

    // ===== Getters e Setters =====

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    // ===== equals(), hashCode() e toString() =====

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News news)) return false;
        return id == news.id &&
                Objects.equals(title, news.title) &&
                Objects.equals(description, news.description) &&
                category == news.category &&
                Objects.equals(imagemUrl, news.imagemUrl) &&
                Objects.equals(text, news.text) &&
                Objects.equals(publishedBy, news.publishedBy) &&
                Objects.equals(publishedDate, news.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, category, imagemUrl, text, publishedBy, publishedDate);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", text='" + text + '\'' +
                ", publishedBy='" + publishedBy + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
