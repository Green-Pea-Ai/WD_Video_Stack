package com.example.demo.controller;

import com.example.demo.entity.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("musics")
public class MusicController {

    // sout보다 log가 라이트하게 쓸 수 있다.
    final static Logger log =
            LoggerFactory.getLogger(MusicController.class);

    /*private static final Logger logger =
            LoggerFactory.getLogger(MusicController.class);*/

    @GetMapping("")
    public ModelAndView musicIndex() {
        log.info("musicIndex()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicIndex");

        return modelAndView;
    }

    @GetMapping("/test")
    public Music musicTest() {
        log.info("musicTest()");

        Music music = new Music();

        return music;
    }

    @GetMapping("/play")
    public ModelAndView musicPlay() {
        log.info("musicPlay()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicPlay");

        return modelAndView;
    }

    @GetMapping("/menu")
    public String musicMenu() {
        log.info("musicMenu()");

        return "music/musicMenu";
    }

    @GetMapping("/record")
    public String musicRecord() {
        log.info("musicRecord()");

        return "music/musicRecord";
    }





    // 내가 직접 작성한 코드(my_practice)
    @PostMapping("/html/wd_music_play")
    public String getMusicPlay() {
        log.info("getMusicPlay(POST)");

        return "musicPlay";
    }

    @PostMapping("/html/wd_view_menu")
    public String getViewMenu() {
        log.info("getViewMenu(Post)");

        return "menuView";
    }

    @PostMapping("/html/wd_record")
    public String getRecord() {
        log.info("getRecord(Post)");

        return "record";
    }

}
