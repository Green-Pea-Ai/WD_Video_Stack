package com.example.demo.service.s7;

import com.example.demo.entity.s7.VideoBoard;
import com.example.demo.entity.s7.VideoCrawlTable;
import com.example.demo.repository.s7.VideoBoardRepository;
import com.example.demo.repository.s7.VideoCrawlRepository;
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

    @Autowired
    private VideoCrawlRepository crawlRepository;

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

    /*
    // Search func, Impl에서 검색 메서드를 만들지 않아도 JPA가 알아서 해준다.
    @Override
    public List<VideoBoard> findByMovTitleContaining(String videoKeyword) throws Exception {
        List<VideoBoard> videoBoards = repository.findByMovTitleContaining(videoKeyword);

        return videoBoardList;
    } */

    @Override
    public List<VideoCrawlTable> crawlListFromServ() throws Exception {
        List<Object[]> valArrays = crawlRepository.listAllVideoCrawlTable();
        List<VideoCrawlTable> videoCrawlTables = new ArrayList<>();

        for(Object[] valArr: valArrays) {
            VideoCrawlTable videoCrawlTable = new VideoCrawlTable();

            videoCrawlTable.setYoutubeNo((Long) valArr[0]);
            videoCrawlTable.setYoutuberName((String) valArr[1]);
            videoCrawlTable.setYoutubeTitle((String) valArr[2]);
            videoCrawlTable.setYoutubePlayTime((String) valArr[3]);
            videoCrawlTable.setSubscribeNum((String) valArr[4]);
            videoCrawlTable.setViewsNum((String) valArr[5]);
            videoCrawlTable.setUploadTime((String) valArr[6]);
            videoCrawlTable.setCrawlingTime((String) valArr[7]);
            videoCrawlTable.setYoutubeLink((String) valArr[8]);

            videoCrawlTables.add(videoCrawlTable);
        }

        // List 리턴
        return videoCrawlTables;
    }
}
