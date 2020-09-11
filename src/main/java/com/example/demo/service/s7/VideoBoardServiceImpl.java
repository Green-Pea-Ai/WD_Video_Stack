package com.example.demo.service.s7;

import com.example.demo.entity.s7.VideoBoard;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class VideoBoardServiceImpl implements VideoBoardService {

    @Autowired
    private VideoBoardRepository repository;

    @Override
    public void registerFromServ(VideoBoard videoBoard) throws Exception {
        repository.create(videoBoard);
    }

    @Override
    public VideoBoard readFromServ(Long videoNo) throws Exception {
        log.info("VideoBoardService read(videoNo): " + videoNo);

        return repository.read(videoNo);
    }

    @Override
    public void modifyFromServ(VideoBoard videoBoard) throws Exception {
        log.info("VideoBoardService modify(videoBoard): " + videoBoard);
        repository.update(videoBoard);
    }

    // ??? videoBoard > videoNo
    @Override
    public void removeFromServ(Long videoNo) throws Exception {

        repository.delete(videoNo);
    }

    @Override
    public List<VideoBoard> listFromServ() throws Exception {
        return repository.list();
    }
}
