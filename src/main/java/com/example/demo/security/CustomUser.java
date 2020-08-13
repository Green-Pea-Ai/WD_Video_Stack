package com.example.demo.security;

import com.example.demo.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CustomUser extends User {
    private Member member;

    // Collection은 자료구조
    public CustomUser(String username, String passwd,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, passwd, authorities);
    }

    public CustomUser(Member member) {
        // stream, map은 병렬처리로 속도를 빠르게 해주는 메서드
        super(member.getUserId(), member.getUserPw(),
                member.getAuthList().stream()
                        .map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
                        .collect(Collectors.toList()));

        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
