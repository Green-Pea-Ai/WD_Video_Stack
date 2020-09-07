package com.example.demo.repository.s6;

import com.example.demo.entity.s6.ClickedNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickedNewsRepository extends JpaRepository<ClickedNews, Long> {
    public ClickedNews findByClickedNewsNo(String clickedNewsNo);
}
