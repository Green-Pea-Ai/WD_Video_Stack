package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor // 인자없는 생성자 호출하겠다
// DB 생성은 @Entity가 진행함
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    @Builder
    public News(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}
