package com.example.demo.security.s7;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VideoCustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        /* Error Handling & Info */
        VideoErrorInfoApi videoErrorInfoApi = new VideoErrorInfoApi();
        videoErrorInfoApi.setMessageFromVEIA("Access Denied");

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(videoErrorInfoApi);

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(403);
        response.getWriter().write(jsonString);
    }
}
