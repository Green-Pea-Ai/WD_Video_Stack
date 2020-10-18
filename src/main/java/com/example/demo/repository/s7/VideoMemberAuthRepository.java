package com.example.demo.repository.s7;

import com.example.demo.entity.s7.VideoMemberAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VideoMemberAuthRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public VideoMemberAuth checkAuthFromRepo(Long userNo) throws Exception {
        List<VideoMemberAuth> results = jdbcTemplate.query(
            "select user_no, auth from video_member_auth where user_auth_no = ?",
            new RowMapper<VideoMemberAuth>() {
                @Override
                public VideoMemberAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
                    VideoMemberAuth vmAuth = new VideoMemberAuth();

                    vmAuth.setUserNo(rs.getLong("user_no"));
                    vmAuth.setAuth(rs.getString("auth"));

                    return vmAuth;
                }
            }, userNo
        );
        // 3항 연산자, results가 isEmpty()면 null이고 아니면 results.get(0)해라.
        // isEmpty(): 인스턴스 생성됨, 공백값("") 입력되어있음
        return results.isEmpty() ? null : results.get(0);
    }
}
