package com.example.demo.repository.s6;

import com.example.demo.entity.s6.News;
import org.springframework.data.jpa.repository.JpaRepository;

// 클래스로 하면 추상화하라는 오류 메시지 발생하는 이유?
// Class 'NewsRepository' must either be declared
// abstract or implement abstract method 'findAll()' in 'JpaRepository'
public interface NewsRepository extends JpaRepository<News, Long> {
    public News findByNewsNo(String newsNo);
}
