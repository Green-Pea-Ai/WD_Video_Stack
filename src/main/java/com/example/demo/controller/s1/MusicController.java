package com.example.demo.controller.s1;

import com.example.demo.entity.s1.Music;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Controller는 HTML 핸들링에 특화되어 있으므로
// 데이터를 처리하고자 할 경우 ResponseEntity를 활용해줘야 한다.
// @RestController는 json 형식으로 데이터 처리에 특화되어 있으므로
// HTML을 처리하고자 할 경우 ModelAndView를 활용해야 한다.

// @RestController - json 씀, Controller는 html 파싱할 때 씀
// 코딩 목적에 적절한 컨트롤러를 써야 코드 양을 줄일 수 있다.
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
    public ModelAndView musicMenu() {
        log.info("musicMenu()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicMenu");

        return modelAndView;
    }

    @GetMapping("/record")
    public ModelAndView musicRecord() {
        log.info("musicRecord()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicRecord");

        return modelAndView;
    }

    @GetMapping("/titles")
    public List<Music> musicTitles() {
        log.info("musicTitles()");

        List<Music> list = new ArrayList<>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return list;
    }

    @GetMapping("/artists")
    public Map<String, Music> musicArtists() {
        log.info("musicArtists()");

        Map<String, Music> map = new HashMap<String, Music>();

        Music music1 = new Music();
        map.put("MC 홍길동", music1);

        Music music2 = new Music();
        map.put("ABC", music2);

        return map;
    }

    @GetMapping("/resptest")
    // 파이썬 등 데이터 주고받을 때 중요하다.
    public ResponseEntity<Void> musicRespTest() {
        log.info("musicRespTest");

        // Controller에서 json 처리를 하려면
        // ResponseEntity(legacy임)를 쓰면 된다
        // RestController는 html 핸들링 못해서
        // ModelAndView가 필요하다.
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/respstring")
    public ResponseEntity<String> musicRespString() {
        log.info("musicRespString()");

        // 음악 재생 버튼 클릭시 나오는 페이지와 같은 기능을 한다.
        return new ResponseEntity<String>(
                "Success", HttpStatus.OK
        );
    }


    @GetMapping("/respclass")
    public ResponseEntity<Music> musicRespClass() {
        log.info("musicRespClass()");

        Music music = new Music();

        return new ResponseEntity<Music>(music, HttpStatus.OK);
    }

    @GetMapping("/resplist")
    public ResponseEntity<List<Music>> musicRespList() {
        log.info("musicRespList");

        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return new ResponseEntity<List<Music>>(list, HttpStatus.OK);
    }

    // 이미지는 0~255의 숫자를 사용해 처리를 함
    // 2^8=256 8비트, 즉 1바이트가 이미지 포맷의 크기다.
    // byte 배열 형식으로 이미지를 처리함
    @GetMapping("respfile")
    public ResponseEntity<byte[]> musicImgFile() throws Exception {
        log.info("musicImgFile()");

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();

            in = new FileInputStream("/home/bitai/proj/PythonWorkshop/test_image_1.jpg");
            headers.setContentType(MediaType.IMAGE_JPEG);

            // 그래들 파일에 추가
            // compile group: 'org.apache.commons', name: 'commons-io', version: '1.3.2'
            entity = new ResponseEntity<byte[]>(
                    IOUtils.toByteArray(in),
                    headers,
                    HttpStatus.CREATED
            );
        } catch(Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            // throws Exception을 써줘야 오류가 없어짐
            in.close();
        }

        return entity;
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
