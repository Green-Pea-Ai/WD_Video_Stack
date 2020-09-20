package com.example.demo.service.s7;

import com.example.demo.entity.s7.VideoBoard;

import java.util.List;

public interface VideoBoardService {
    public void registerFromServ(VideoBoard videoBoard) throws Exception;
    public VideoBoard readFromServ(Long videoNo) throws Exception;
    public void modifyFromServ(VideoBoard videoBoard) throws Exception;
    public void removeFromServ(Long videoBoard) throws Exception;
    public List<VideoBoard> listFromServ() throws Exception;

}
