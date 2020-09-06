package com.example.demo.controller.s2.p1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueTestController {

    @GetMapping("/vuetest")
    public String vueIndex() {
        return "vuetest/vueIndex";
    }
}
