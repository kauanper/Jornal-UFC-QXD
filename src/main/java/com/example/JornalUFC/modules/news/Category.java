package com.example.JornalUFC.modules.news;

public enum Category {
    PESQUISA("admin"),
    EXTENSAO("extensao"),
    ENSINO("ensino"),
    EVENTOS("eventos"),
    COMUNIDADE("comunidade"),
    DESTAQUE("destaque");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
