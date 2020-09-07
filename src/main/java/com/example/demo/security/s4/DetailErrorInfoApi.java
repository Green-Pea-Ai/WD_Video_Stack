package com.example.demo.security.s4;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 내부 멤버 변수로 만드는 생성자를 디폴트로
// 만들게 해주는 롬복 어노테이션 인터페이스
@AllArgsConstructor
@Getter
public class DetailErrorInfoApi {
    private String target;
    private String message;
}
