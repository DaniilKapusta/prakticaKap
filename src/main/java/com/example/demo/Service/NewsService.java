package com.example.demo.Service;


import com.example.demo.Dto.NewsDto;
import com.example.demo.Repository.NewsRepository;
import com.example.demo.entity.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public List<NewsDto> getNewsAllDto() {
        List<NewsDto> newsDtos = new ArrayList<>();
        newsRepository.findAll().forEach(news -> {
            NewsDto newsDto = mapToDto(news);
            newsDtos.add(newsDto);
        });
        return newsDtos;
    }

    public NewsDto saveNews(NewsDto dto) {
        NewsEntity newsEntity = mapToEntity(dto);
        dto.setId(newsRepository.save(newsEntity).getId());
        return dto;
    }

    public void deleteNewsByName(String title) {
        newsRepository.findByTitle(title).forEach(news -> {
            newsRepository.delete(news);
        });

    }
    private NewsEntity mapToEntity(NewsDto newsDto) {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setImage(newsDto.getImage());
        newsEntity.setTitle(newsDto.getTitle());
        newsEntity.setText(newsDto.getText());
        newsEntity.setMiniNews(newsDto.getMiniNews());
        return newsEntity;
    }
    private NewsDto mapToDto(NewsEntity newsEntity) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(newsEntity.getId());
        newsDto.setImage(newsEntity.getImage());
        newsDto.setTitle(newsEntity.getTitle());
        newsDto.setText(newsEntity.getText());
        newsDto.setMiniNews(newsEntity.getMiniNews());
        return newsDto;
    }
}
