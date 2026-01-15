package com.example.JornalUFC.modules.news;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "News")
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private String imagemUrl;
    private String text;
    private String publishedBy;
    private LocalDateTime publishedDate;
}
