package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class DemoApplication {
	final static Logger log =
			LoggerFactory.getLogger(DemoApplication.class);

	// SpringApplication.run 하면
	// 웹 서버가 구동된다 - 서비스 번호: 8080
	public static void main(String[] args) throws Exception {

		// hs = HelloSpring() <- 파이썬 코드
		// HelloSpring hs = new HelloSpring();
		// HelloSpring hs = new HelloSpring();
		// log.info(hs.print());

		SpringApplication.run(DemoApplication.class, args);
	}

}
