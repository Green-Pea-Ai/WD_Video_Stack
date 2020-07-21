package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

// RestController vs Controller
// DemoApplication에 main()이 동작하면서 자바 코드가 동작한다.
// 아래와 같은 Annotation이 붙어있으면
// 자동으로 스프링 프레임웍이 URL 맵핑을 제어하는 제어유닛으로 바라본다.

@Controller
public class MainController {
    static final Logger log =
            LoggerFactory.getLogger(MainController.class);

    // localhost:8080/으로 접속하면
    // 제어 유닛이 아래 코드를 실행시킨다.
    // localhost:8080 <<--- 아이피 주소와 포트 번호
    @GetMapping("/")
    public String index(Locale locale, Model model) {
        log.info("index()");

        // 현재 날짜를 받아온다.
        Date date = new Date();
        // DateFormat.getDateTimeInstance를 통해
        // 연월일 시간 정보와 지역 정보를 출력하도록 만든다.
        // 형식 지정자
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG, locale
        );

        // 위의 정보를 문자
        // 주어진 형식대로
        String formattedDate = dateFormat.format(date);
        // 최종적으로
        model.addAttribute("servTime", formattedDate);

        // Model - 데이터(객체, 메모리에 올라가는 애들?)
        // View - 화면(보는거): HTML
        // Controller - RestController & Controller

        // index.html을 보여준다.
        return "index";
    }
}
