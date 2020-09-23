package com.example.demo.entity.s7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@JsonIgnoreProperties(value = "hibernateLazyInitializer")

@Getter
@Setter

@EqualsAndHashCode(of = "youtubeNo")
@ToString
@Entity

public class VideoCrawlTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private long youtubeNo;
    @Column
    private String youtuberName;
    @Column
    private String youtubeTitle;
    @Column
    private String youtubePlayTime;
    @Column
    private String subscribeNum;
    @Column
    private String viewsNum;
    @Column
    private String uploadTime;
    @Column
    private String crawlingTime;
    @Column
    private String youtubeLink;

}
