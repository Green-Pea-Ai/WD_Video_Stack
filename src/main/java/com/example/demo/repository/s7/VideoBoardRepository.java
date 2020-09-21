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

    @Query("select vb.videoNo, vb.movTitle, vb.director, vb.content, vb.regDate from VideoBoard vb " +
                "where vb.videoNo > 0 order by vb.videoNo desc")
    public List<Object[]> listAllVideoBoard();

    public List<VideoBoard> findByMovTitleContainingOrderByVideoNoDesc(String videoKeyword);
}
