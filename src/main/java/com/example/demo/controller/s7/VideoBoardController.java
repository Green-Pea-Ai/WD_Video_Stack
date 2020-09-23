package com.example.demo.controller.s7;

import com.example.demo.controller.MainController;
import com.example.demo.entity.s7.VideoBoard;
import com.example.demo.entity.s7.VideoCrawlTable;
import com.example.demo.repository.s7.VideoBoardRepository;
import com.example.demo.service.s7.VideoBoardService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Log
@RestController
@RequestMapping("/videos")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
// @CrossOrigin(origins = "http://localhost:5000", allowedHeaders = "*")
// 요청(request)을 뷰가 하고 컨트롤러는 응답(response)한다.
// 플라스크는 리퀘스터를 하나 만들어야 한다.
public class VideoBoardController {

    @Autowired
    private VideoBoardService service;

    @Autowired
    private VideoBoardRepository videoBoardRepository;

    // 게시판 리스트 출력
    @GetMapping("")
    public ResponseEntity<List<VideoBoard>> list() throws Exception {
        log.info("wd list()");

        return new ResponseEntity<>(service.listFromServ(), HttpStatus.OK);
    }

    // 크롤링 게시판 리스트 출력
    @GetMapping("/crawl")
    public ResponseEntity<List<VideoCrawlTable>> crawlList() throws Exception {
        log.info("wd crawl list()");

        return new ResponseEntity<>(service.crawlListFromServ(), HttpStatus.OK);
    }

    @GetMapping("/{videoNo}")
    // 비동기 상태로 데이터를 들고오기 때문에 readOnly 속성을 넣어줘야 한다?
    // 아래 한줄로 read 안되던 것 바로 해결됨
    @Transactional(readOnly = true)
    public ResponseEntity<VideoBoard> read(
            @PathVariable("videoNo") Long videoNo) throws Exception {
        log.info("wd read(): " + videoNo);

        VideoBoard videoBoard = service.readFromServ(videoNo);
        System.out.println("VideoBoardController: " + videoBoard);

        return new ResponseEntity<VideoBoard>(videoBoard, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<VideoBoard> register(
            @Validated @RequestBody VideoBoard videoBoard,
            UriComponentsBuilder uriBuilder) throws Exception {
        log.info("POST wd register()");

        service.registerFromServ(videoBoard);

        log.info("register videoBoard.getVideoNo() = " + videoBoard.getVideoNo());

        return new ResponseEntity<>(videoBoard, HttpStatus.OK);
    }

    @DeleteMapping("/{videoNo}")
    public ResponseEntity<Void> remove(
            @PathVariable("videoNo") Long videoNo) throws Exception {
        log.info("wd remove!");

        service.removeFromServ(videoNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{videoNo}")
    public ResponseEntity<VideoBoard> modify(
            @PathVariable("videoNo") Long videoNo,
            @Validated @RequestBody VideoBoard videoBoard) throws Exception {
        log.info("Put - wd modify()");
        System.out.println(videoBoard);

        videoBoard.setVideoNo(videoNo);
        service.modifyFromServ(videoBoard);

        return new ResponseEntity<>(videoBoard, HttpStatus.OK);
    }

    // Search func
    @GetMapping("/search/{movTitle}")
    public List<VideoBoard> findByMovTitleContaining(@PathVariable("movTitle") String videoKeyword) throws Exception {

        log.info("=========Get, search(videoKeyword)=========");
        System.out.println(videoKeyword);

        List<VideoBoard> videoBoard = videoBoardRepository.findByMovTitleContainingOrderByVideoNoDesc(videoKeyword);

        System.out.println("videoBoard: " + videoBoard);
        return videoBoard;
    }

    // Flask <-> Spring 통신용
    @GetMapping("/csv_download")
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

        // 위의 정보를 String 형태의 변수에 담음
        // 주어진 형식대로
        String formattedDate = dateFormat.format(date);
        // 최종적
        model.addAttribute("servTime", formattedDate);

        // index.html을 보여준다.
        return "index";
    }
}