package com.example.demo.service.s6;

import com.example.demo.entity.ClickedNews;
import com.example.demo.entity.HomeNews;
import com.example.demo.entity.News;
import com.example.demo.repository.ClickedNewsRepository;
import com.example.demo.repository.HomeNewsRepository;
import com.example.demo.repository.NewsRepository;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy // 지연로딩, 실제 사용될 때 로딩됨, @Bean은 즉시 로딩
@Log
public class NewsCrawlService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    HomeNewsRepository homeNewsRepository;

    @Autowired
    ClickedNewsRepository clickedNewsRepository;

    private Document document;

    // 크롤링에서 제일 중요한 부분
    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            // Jsoup이 있어야 크롤링 가능
            // userAgent 설정은 리눅스 환경이라면 다른데서도 저렇게 쓰면 된다
            // 웹 브라우저들은 동작 방식이 다르다. 플랫폼 전쟁 (천조 기업?)
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }
    // 엔티티는 롬복으로 한줄컷
    // 리포지토리는 JPA로 한줄컷
    // 데이터가 DB가 아닌 컴퓨터로 들어오면 큰일이 발생할 수 있다.
    public List<News> newsFindAll() {
        log.info("newsFindAll()");

        // JPA 사용
        return newsRepository.findAll();
    }

    public List<HomeNews> homeNewsFindAll() {
        log.info("homeNewsFindAll()");

        return homeNewsRepository.findAll();
    }

    public void crawlingHome() {
        log.info("crawlingHome()");

        // ???
        homeNewsRepository.deleteAll();
        document = connectUrl("https://news.daum.net");

        Elements total = document.select("strong.tit_thumb>a.link_txt");
        Elements image = document.select("div.item_issue>a.link_thumb>img.thumb_g");

        HomeNews homeNews = null;

        for (int i =0; i < total.size(); i++) {
            homeNews = new HomeNews();
            homeNews.setHomeNewsNo(String.valueOf(i + 1));
            homeNews.setTitle(total.get(i).text());
            homeNews.setAddress(total.get(i).attr("href"));
            homeNews.setImage(image.get(i).attr("src"));
            homeNewsRepository.save(homeNews);
        }
    }

    public void mainCrawler(String category) {
        log.info("mainCrawler(): " + category);

        document = connectUrl("https://news.daum.net/" + category);
        // ???
        newsRepository.deleteAll();

        daumNews(document.select("div.item_mainnews>div.cont_thumb>strong.tit_thumb>a"), category);
        daumNews(document.select("ul.item_mainnews>li>div.cont_thumb>strong.tit_thumb>a"), category);
        daumNews(document.select("strong.tit_mainnews>a"), category);
        daumNews(document.select("ul.list_issue>li>a.link_txt"), category);
    }

    public void daumNews(Elements elements, String category) {
        log.info("daumNews(): elements - " + elements + ", category - " + category);

        News news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new News();

            news.setNewsNo(String.valueOf(newsRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            news.setTitle(elements.get(i).text());

            // JPA 기능, actions.js로 data를 넘긴다?
            // DB에 데이터가 담기는 위치?
            newsRepository.save(news);
        }
    }

    public ClickedNews crawlingOne(String newsNo) {
        log.info("crawlingOne(): " + newsNo);

        News news = newsRepository.findByNewsNo(newsNo);

        ClickedNews clickedNews = new ClickedNews();

        clickedNews.setTitle(news.getTitle());
        clickedNews.setCategory(news.getCategory());
        clickedNews.setAddress(news.getAddress());
        clickedNews.setClickedNewsNo(String.valueOf(clickedNewsRepository.findAll().size() + 1));

        document = connectUrl(clickedNews.getAddress());

        clickedNews.setDate(document.select("span.num_date").text());
        clickedNews.setContents(document.select("div.article_view>section>:not(figure)").text());

        clickedNewsRepository.save(clickedNews);

        return clickedNews;
    }
}
