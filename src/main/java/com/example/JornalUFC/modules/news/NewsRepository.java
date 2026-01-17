package com.example.JornalUFC.modules.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    Optional<News> findById(Long id);

    @Query("""
        SELECT n FROM News n
        ORDER BY
            CASE n.category
                WHEN 'DESTAQUE' THEN 1
                WHEN 'PESQUISA' THEN 2
                WHEN 'EXTENSAO' THEN 3
                WHEN 'ENSINO' THEN 4
                WHEN 'EVENTOS' THEN 5
                WHEN 'COMUNIDADE' THEN 6
                ELSE 7
            END,
            n.publishedDate DESC
    """)
    List<News> findAllOrderedByCategory();
}
