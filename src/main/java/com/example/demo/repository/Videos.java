package com.example.demo.repository;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
// 인자가 없는 생성자 생성
@NoArgsConstructor
@Entity
public class Videos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoSeq;

    @Column(length = 20, nullable = false)
    private String videoNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    @Builder
    public Videos(String videoNo, String category, String title, String address) {
        this.videoNo = videoNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}
