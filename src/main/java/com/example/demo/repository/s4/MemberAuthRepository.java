package com.example.demo.repository.s4;

import com.example.demo.entity.s4.MemberAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberAuthRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MemberAuth checkAuth(Long userNo) throws Exception {
        List<MemberAuth> results = jdbcTemplate.query(
            "select user_no, auth from member_auth where user_auth_no = ?",
            new RowMapper<MemberAuth>() {
                @Override
                public MemberAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
                    MemberAuth mAuth = new MemberAuth();

                    mAuth.setUserNo(rs.getLong("user_no"));
                    mAuth.setAuth(rs.getString("auth"));

                    return mAuth;
                }
            }, userNo
        );
        // 3항 연산자, results가 isEmpty()면 null이고 아니면 results.get(0)해라.
        // isEmpty(): 인스턴스 생성됨, 공백값("") 입력되어있음
        return results.isEmpty() ? null : results.get(0);
    }
}
