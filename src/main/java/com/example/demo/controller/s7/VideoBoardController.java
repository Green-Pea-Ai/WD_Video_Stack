package com.example.demo.controller.s7;

import com.example.demo.entity.s7.VideoBoard;
import com.example.demo.service.s7.VideoBoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
    public ResponseEntity<List<VideoBoard>> list() throws Exception {
        log.info("wd list()");

        return new ResponseEntity<>(service.listFromServ(), HttpStatus.OK);
    }

    @GetMapping("/{videoNo}")
    public ResponseEntity<VideoBoard> read(
            @PathVariable("videoNo") Long videoNo) throws Exception {
        log.info("wd read()");

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

}