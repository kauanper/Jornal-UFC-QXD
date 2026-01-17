package com.example.JornalUFC.modules.news;

public enum Category {
    DESTAQUE("destaque"),
    PESQUISA("pesquisa"),
    EXTENSAO("extensao"),
    ENSINO("ensino"),
    EVENTOS("eventos"),
    COMUNIDADE("comunidade");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
