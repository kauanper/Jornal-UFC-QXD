package com.example.JornalUFC.modules.news;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
}
