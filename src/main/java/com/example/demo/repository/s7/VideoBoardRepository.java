package com.example.demo.repository.s7;

import com.example.demo.entity.s7.VideoBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoBoardRepository extends JpaRepository<VideoBoard, Long> {

    // 게시판 리스트 출력
    @Query("select vb.videoNo, vb.movTitle, vb.director, vb.content, vb.regDate from VideoBoard vb " +
                "where vb.videoNo > 0 order by vb.videoNo desc")
    // @Query("select * from VideoBoard vb where vb.videoNo > 0 order by vb.videoNo asc")
    public List<Object[]> listAllVideoBoard();

    // 게시판 검색 기능
    public List<VideoBoard> findByMovTitleContainingOrderByVideoNoDesc(String videoKeyword);


    // 크롤링 게시판 리스트 출력
    // select * from 등 축약어로 쓰면 인식을 못하는듯 함
    //@Query("select * from VideoCrawlTable vct " +
    //        "where vct.youtubeNo > 0 order by vct.youtubeNo asc")
    @Query("select vct.youtubeNo, vct.youtuberName, vct.youtubeTitle, vct.youtubePlayTime, vct.subscribeNum, vct.viewsNum, vct.uploadTime, vct.crawlingTime, vct.youtubeLink from VideoCrawlTable vct " +
    "where vct.youtubeNo > 0 order by vct.youtubeNo asc")
    public List<Object[]> listAllVideoCrawlTable();
}
