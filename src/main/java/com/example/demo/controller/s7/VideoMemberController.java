package com.example.demo.controller.s7;

import com.example.demo.entity.s4.Member;
import com.example.demo.entity.s7.VideoMember;
import com.example.demo.entity.s7.VideoMemberAuth;
import com.example.demo.security.s7.VideoAuthUtil;
import com.example.demo.service.s7.VideoMemberAuthService;
import com.example.demo.service.s7.VideoMemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Log
@RestController
@RequestMapping("/video_users")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VideoMemberController {
    // Autowired ================================================================================
    @Autowired
    private VideoMemberService service;

    @Autowired
    private VideoMemberAuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    // ================================================================================
    @PostMapping("")
    public ResponseEntity<VideoMember> register(@Validated @RequestBody VideoMember videoMember)
            throws Exception {
        log.info("videoMember.getUserName(): " + videoMember.getUserName());

        String inputPassword =  videoMember.getUserPw();
        videoMember.setUserPw(passwordEncoder.encode(inputPassword));

        service.registerFromServ(videoMember);

        log.info("register member.getUserNo(): " + videoMember.getUserNo());

        return new ResponseEntity<>(videoMember, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<VideoMember>> list() throws Exception {
        return new ResponseEntity<>(service.listFromServ(), HttpStatus.OK);
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<VideoMember> read(@PathVariable("userNo") Long userNo) throws Exception {
        VideoMember videoMember = service.readFromServ(userNo);

        return new ResponseEntity<>(videoMember, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{userNo}")
    public ResponseEntity<Void> remove(@PathVariable("userNo") Long userNo) throws Exception {
        service.removeFromServ(userNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{userNo}")
    public ResponseEntity<VideoMember> modify(@PathVariable("userNo") Long userNo,
                                              @Validated @RequestBody VideoMember videoMember)
            throws Exception {
        log.info("modify - videoMember.getUserName(): " + videoMember.getUserName());
        log.info("modify - userNo: " + userNo);

        videoMember.setUserNo(userNo);
        service.modifyFromServ(videoMember);

        return new ResponseEntity<>(videoMember, HttpStatus.OK);
    }

    @RequestMapping(value = "/setup",
                    method = RequestMethod.POST,
                    produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> setupAdmin(@Validated @RequestBody VideoMember videoMember)
            throws Exception {
        log.info("setupAdmin: videoMember.getUserName(): " + videoMember.getUserName());
        log.info("setupAdmin: service.countAll" + service.countAllFromServ());

        if (service.countAllFromServ() == 0) {
            String inputPassword = videoMember.getUserPw();
            videoMember.setUserPw(passwordEncoder.encode(inputPassword));

            // 암호 암호화하는 곳(Encryption, Decryption)
            videoMember.setJob("Admin");

            service.setupAdminFromServ(videoMember);

            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }

        String message = messageSource.getMessage("common.cannotSetupAdmin",
                null, Locale.KOREAN);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/myinfo")
    public ResponseEntity<VideoMemberAuth> getMyInfo(
            @RequestHeader (name="Authorization") String header) throws Exception {
        Long userNo = VideoAuthUtil.getUserNo(header);
        log.info("register userNo: " + userNo);

        VideoMemberAuth auth = authService.readFromAuthServ(userNo);
        log.info("auth: " + auth);

        return new ResponseEntity<>(auth, HttpStatus.OK);
    }

}
