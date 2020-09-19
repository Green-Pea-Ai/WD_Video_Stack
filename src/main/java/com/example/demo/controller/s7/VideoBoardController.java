package com.example.demo.controller.s7;

import com.example.demo.entity.s7.VideoBoard;
import com.example.demo.repository.s7.VideoBoardRepository;
import com.example.demo.service.s7.VideoBoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Log
@RestController
@RequestMapping("/videos")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VideoBoardController {

    @Autowired
    private VideoBoardService service;

    @Autowired
    private VideoBoardRepository videoBoardRepository;

    @GetMapping("")
    public ResponseEntity<List<VideoBoard>> list() throws Exception {
        log.info("wd list()");

        return new ResponseEntity<>(service.listFromServ(), HttpStatus.OK);
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
    @GetMapping("/{movTitle}")
    public List<VideoBoard> findByMovTitleContaining(@PathVariable String movTitle) {

        List<VideoBoard> videoBoard = videoBoardRepository.findByMovTitleContaining(movTitle);

        return videoBoard;
    }
}