package com.example.demo.repository.s7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VideoBoardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
