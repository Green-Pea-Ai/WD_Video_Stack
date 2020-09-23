package com.example.demo.repository.s7;

import com.example.demo.entity.s7.VideoCrawlTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoCrawlRepository extends JpaRepository<VideoCrawlTable, Long> {

    // 크롤링 게시판 리스트 출력
    // select * from 등 축약어로 쓰면 인식을 못하는듯 함
    //@Query("select * from VideoCrawlTable vct " +
    //        "where vct.youtubeNo > 0 order by vct.youtubeNo asc")
    @Query("select vct.youtubeNo, vct.youtuberName, vct.youtubeTitle, vct.youtubePlayTime, vct.subscribeNum, vct.viewsNum, vct.uploadTime, vct.crawlingTime, vct.youtubeLink from VideoCrawlTable vct " +
            "where vct.youtubeNo > 0 order by vct.youtubeNo desc")
    public List<Object[]> listAllVideoCrawlTable();

    // 크롤링 게시판 검색 기능
    public List<VideoCrawlTable> findByYoutubeTitleContainingOrderByYoutubeNoAsc(String youtubeKeyword);
}
