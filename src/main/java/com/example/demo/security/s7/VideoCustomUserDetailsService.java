package com.example.demo.security.s7;

import com.example.demo.entity.s7.VideoMember;
import com.example.demo.repository.s7.VideoMemberRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log
public class VideoCustomUserDetailsService implements UserDetailsService {

    @Autowired
    private VideoMemberRepository videoMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("vd userName: " + username);

        VideoMember videoMember = videoMemberRepository.findByUserId(username).get(0);

        log.info("vd member: " + videoMember);

        return videoMember == null ? null : new VideoCustomUser(videoMember);
    }
}
