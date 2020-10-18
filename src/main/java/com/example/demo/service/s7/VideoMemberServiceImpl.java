package com.example.demo.service.s7;

import com.example.demo.entity.s7.VideoMember;
import com.example.demo.entity.s7.VideoMemberAuth;
import com.example.demo.repository.s7.VideoMemberAuthRepository;
import com.example.demo.repository.s7.VideoMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
// VideoMemberService 인터페이스에서 기능을 상속받고 여기서는 속성을 구현
public class VideoMemberServiceImpl implements VideoMemberService {
    static final Logger log = LoggerFactory.getLogger(VideoMemberServiceImpl.class);

    @Autowired
    private VideoMemberRepository repository;

    @Override
    public void registerFromServ(VideoMember videoMember) throws Exception {
        VideoMember memEntity = new VideoMember();
        memEntity.setUserId(videoMember.getUserId());
        memEntity.setUserPw(videoMember.getUserPw());
        memEntity.setUserName(videoMember.getUserName());
        memEntity.setJob(videoMember.getJob());

        VideoMemberAuth videoMemberAuth = new VideoMemberAuth();
        videoMemberAuth.setAuth("ROLE_MEMBER");

        memEntity.addAuth(videoMemberAuth);

        repository.save(memEntity);

        videoMember.setUserNo(memEntity.getUserNo());
    }

    @Override
    public void setupAdminFromServ(VideoMember videoMember) throws Exception {

        VideoMember memEntity = new VideoMember();
        memEntity.setUserId(videoMember.getUserId());
        memEntity.setUserPw(videoMember.getUserPw());
        memEntity.setUserName(videoMember.getUserName());
        memEntity.setJob(videoMember.getJob());

        VideoMemberAuth videoMemberAuth = new VideoMemberAuth();
        videoMemberAuth.setAuth("ROLE_ADMIN");

        memEntity.addAuth(videoMemberAuth);

        // JPA
        repository.save(memEntity);
    }

    @Override
    public VideoMember readFromServ(Long userNo) throws Exception {
        log.info("VideoMember Service read()");

        // JPA
        return repository.getOne(userNo);
    }

    @Override
    public void modifyFromServ(VideoMember videoMember) throws Exception {
        VideoMember memEntity = repository.getOne(videoMember.getUserNo());
        memEntity.setUserName(videoMember.getUserName());
        memEntity.setJob(videoMember.getJob());

        // 권한 수정하는 작업
        List<VideoMemberAuth> videoMemberAuthList = memEntity.getAuthList();
        List<VideoMemberAuth> authList = videoMember.getAuthList();

        for(int i = 0; i < authList.size(); i++) {
            VideoMemberAuth auth = authList.get(i);

            if(i < videoMemberAuthList.size()) {
                VideoMemberAuth videoMemberAuth = videoMemberAuthList.get(i);
                videoMemberAuth.setAuth(auth.getAuth());
            }
        }
        // JPA
        repository.save(memEntity);
    }

    @Override
    public void removeFromServ(Long userNo) throws Exception {
        // JPA
        repository.deleteById(userNo);
    }

    @Override
    public List<VideoMember> listFromServ() throws Exception {
        List<Object[]> valArrays = repository.listAllVideoMember();
        List<VideoMember> videoMemberList = new ArrayList<VideoMember>();

        for(Object[] valArr : valArrays) {
            VideoMember vm = new VideoMember();

            vm.setUserNo((Long) valArr[0]);
            vm.setUserId((String) valArr[1]);
            vm.setUserPw((String) valArr[2]);
            vm.setUserName((String) valArr[3]);
            vm.setJob((String) valArr[4]);
            vm.setRegDate((Date) valArr[5]);

            videoMemberList.add(vm);
        }

        return videoMemberList;
    }

    @Override
    public long countAllFromServ() throws Exception {

        // JPA
        return repository.count();
        // return 0; 뇌절 조심
    }
}
