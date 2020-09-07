package com.example.demo.service.s3;

import com.example.demo.entity.s3.VueBoard;

import java.util.List;

public interface VueBoardService {
    public void register(VueBoard board) throws Exception;
    public VueBoard read(Long boardNo) throws Exception;
    public void modify(VueBoard board) throws Exception;
    public void remove(Long board) throws Exception;
    public List<VueBoard> list() throws Exception;

}
