package com.example.demo.controller.s2.p2;

import com.example.demo.entity.s2.RandNumMessage;
import com.example.demo.service.s2.RandNumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RandNumController {
    static final Logger log =
            LoggerFactory.getLogger(RandNumController.class);

    @Autowired
    private RandNumService randNumService;

    @GetMapping("/random")
    @ResponseBody
    // ResponseEntity : 동작 성공여부 확인, json 데이터를 넘겨줌?
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("It's operate!");
        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);
    }
}
