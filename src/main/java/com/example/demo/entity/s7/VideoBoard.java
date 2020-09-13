package com.example.demo.entity.s7;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(value = "hibernateLazyInitializer")

@Getter
@Setter

@EqualsAndHashCode(of = "videoNo")
@ToString

@Entity

@Table(name = "video_board")
public class VideoBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_no")
    private long videoNo;

    @Column(length = 100, nullable = false)
    private String movTitle;

    @Column(length = 100, nullable = false)
    private String director;

    @Column(length = 200, nullable = false)
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;
}
