package com.example.demo.service.s7;

import com.example.demo.entity.s7.VideoMember;

import java.util.List;

// 인터페이스는 기능만 가진다, 속성은 따로 구현
public interface VideoMemberService {
    public void registerFromServ(VideoMember videoMember) throws Exception;
    public void setupAdminFromServ(VideoMember videoMember) throws Exception;

    public VideoMember readFromServ(Long userNo) throws Exception;
    public void modifyFromServ(VideoMember videoMember) throws Exception;
    public void removeFromServ(Long userNo) throws Exception;
    public List<VideoMember> listFromServ() throws Exception;
    public long countAllFromServ() throws Exception;
}
