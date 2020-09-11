package com.example.demo.entity.s7;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VideoBoard {
    private long videoNo;
    private String movTitle;
    private String director;
    private String content;
    private Data regDate;
}
