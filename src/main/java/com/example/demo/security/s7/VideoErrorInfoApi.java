package com.example.demo.security.s7;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VideoErrorInfoApi implements Serializable {
    private final List<VideoDetailErrorInfoApi> details =
            new ArrayList<VideoDetailErrorInfoApi>();

    private String messageFromVEIA;

    public void addDetailInfo(String target, String message) {
        details.add(new VideoDetailErrorInfoApi(target, message));
    }

    public List<VideoDetailErrorInfoApi> getDetails() {
        return details;
    }
}
