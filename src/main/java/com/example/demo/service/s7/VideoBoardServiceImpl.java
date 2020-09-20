package com.example.demo.service.s7;

import com.example.demo.entity.s7.VideoBoard;
import com.example.demo.repository.s7.VideoBoardRepository;
import lombok.Data;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log
@Service
@Transactional
public class VideoBoardServiceImpl implements VideoBoardService {

    @Autowired
    private VideoBoardRepository repository;
    // private SessionFactory sessionFactory;

    @Override
    public void registerFromServ(VideoBoard videoBoard) throws Exception {
        VideoBoard vidEntity = new VideoBoard();
        vidEntity.setMovTitle(videoBoard.getMovTitle());
        vidEntity.setDirector(videoBoard.getDirector());
        vidEntity.setContent(videoBoard.getContent());

        repository.save(vidEntity);

        videoBoard.setVideoNo(vidEntity.getVideoNo());
    }

    @Override
    public VideoBoard readFromServ(Long videoNo) throws Exception {
        log.info("VideoBoardService read(videoNo): " + videoNo);

        return repository.getOne(videoNo);
    }

    @Override
    public void modifyFromServ(VideoBoard videoBoard) throws Exception {
        log.info("VideoBoardService modify(videoBoard): " + videoBoard);

        VideoBoard vidEntity = repository.getOne(videoBoard.getVideoNo());
        vidEntity.setMovTitle(videoBoard.getMovTitle());
        vidEntity.setDirector(videoBoard.getDirector());
        vidEntity.setContent(videoBoard.getContent());

        repository.save(vidEntity);
    }

    // ??? videoBoard > videoNo
    @Override
    public void removeFromServ(Long videoNo) throws Exception {

        repository.deleteById(videoNo);
    }

    @Override
    public List<VideoBoard> listFromServ() throws Exception {
        List<Object[]> valArrays = repository.listAllVideoBoard();
        List<VideoBoard> videoBoardList = new ArrayList<VideoBoard>();

        for(Object[] valArr : valArrays) {
            VideoBoard videoBoard = new VideoBoard();

            videoBoard.setVideoNo((Long) valArr[0]);
            videoBoard.setMovTitle((String) valArr[1]);
            videoBoard.setDirector((String) valArr[2]);
            videoBoard.setContent((String) valArr[3]);
            videoBoard.setRegDate((Date) valArr[4]);

            videoBoardList.add(videoBoard);
        }

        return videoBoardList;
    }

}
