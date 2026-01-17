package com.example.JornalUFC.modules.news;

public enum OrderBy {
    ASC("ASC"),
    DESC("DESC");

    private String value;
    private OrderBy(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
