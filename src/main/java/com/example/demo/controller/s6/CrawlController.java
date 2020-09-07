package com.example.demo.controller.s6;

import com.example.demo.entity.s6.ClickedNews;
import com.example.demo.entity.s6.HomeNews;
import com.example.demo.entity.s6.News;
import com.example.demo.service.s6.NewsCrawlService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
// Representational State Transfer(Rest), 대표 상태 전송 컨트롤러
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CrawlController {
    @Autowired
    NewsCrawlService newsCrawler;

    @GetMapping("{category}")
    public List<News> crawling(@PathVariable String category) {
        log.info("crawling(): " + category);

        // mainCrawler가 크롤링의 핵심
        newsCrawler.mainCrawler(category);
        // newsFindAll은 JPA가 있어야 쓸 수 있다.
        return newsCrawler.newsFindAll();
    }

    @GetMapping("news")
    public List<HomeNews> findHome() {
        log.info("findHome()");

        newsCrawler.crawlingHome();
        return newsCrawler.homeNewsFindAll();
    }

    @GetMapping("news/{newsNo}")
    public ClickedNews crawlingOne(@PathVariable String newsNo) {
        log.info("crawlingOne(): " + newsNo);

        return newsCrawler.crawlingOne(newsNo);
    }
}
