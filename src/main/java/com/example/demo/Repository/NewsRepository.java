package com.example.demo.Repository;

import com.example.demo.entity.NewsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsRepository extends CrudRepository<NewsEntity,Long> {
  List<NewsEntity> findByTitle(String title);
}
