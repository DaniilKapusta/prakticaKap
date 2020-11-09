package com.example.demo.Dto;

public class NewsDto {
    private Long id;
    private String title;
    private String image;
    private String text;
    private String miniNews;

    public String getMiniNews() {
        return miniNews;
    }

    public void setMiniNews(String miniNews) {
        this.miniNews = miniNews;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
