package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
// BoardDataAccessObject(BoardDAO), 보통 클래스명을 이렇게 쓰지만
// 보다 명시적인 클래스명으로 생성한다고 하심
// 라이브러리를 쓰면 db 생성 등 과정을 반을 자동으로 쓸 수 있지만
// JPA 쓰기 전 과정으로 JdbcTemplate를 이용해 수동으로 구현해본다.
public class BoardRepository {
    static final Logger log = LoggerFactory.getLogger(BoardRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        log.info("Repository create()");

        String query = "insert into board(" +
                "title, content, writer) values(?, ?, ?)";
        jdbcTemplate.update(query, board.getTitle(),
                board.getContent(), board.getWriter());
    }

    public List<Board> list() throws Exception {
        log.info("Repository list()");

        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, " +
                        "writer, reg_date from board " +
                        "where board_no > 0 order by " +
                        "board_no desc, reg_date desc",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum)
                                            throws SQLException {
                        Board board = new Board();
                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                });

        return results;
    }
}
