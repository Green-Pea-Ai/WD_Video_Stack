package com.example.demo.security.s7;

import com.example.demo.entity.s7.VideoMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class VideoCustomUser extends User {
    private VideoMember videoMember;

    // Collection은 자료구조
    public VideoCustomUser(String username, String password, Collection<? extends GrantedAuthority> grantedAuthorities) {
        super(username, password, grantedAuthorities);
    }

    public VideoCustomUser(VideoMember videoMember) {
        // stream, map은 병렬처리로 속도를 빠르게 해주는 메서드
        super(videoMember.getUserId(), videoMember.getUserPw(), videoMember.getAuthList().stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

        this.videoMember = videoMember;
    }

    public VideoMember getVideoMember() {
        return videoMember;
    }
}
