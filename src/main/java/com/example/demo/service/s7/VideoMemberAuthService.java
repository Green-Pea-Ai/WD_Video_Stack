package com.example.demo.service.s7;

import com.example.demo.entity.s7.VideoMemberAuth;
import com.example.demo.repository.s7.VideoMemberAuthRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class VideoMemberAuthService {
    @Autowired
    VideoMemberAuthRepository authRepository;

    public VideoMemberAuth readFromAuthServ(Long userNo) throws Exception {
        log.info("VideoMemberAuth Service readFromAuthServ()");

        return authRepository.checkAuthFromRepo(userNo);
    }
}
