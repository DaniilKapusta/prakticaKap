package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob
    @Column(name="CONTENT", length=1024)
    private String text;
    private String image;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
