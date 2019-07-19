package com.example.demo;

public class Order {
    private String article;
    private String name;
    private Integer amount;

    public Order() {
    }

    public Order(String article, String name, Integer amount) {
        this.article = article;
        this.name = name;
        this.amount = amount;
    }
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
