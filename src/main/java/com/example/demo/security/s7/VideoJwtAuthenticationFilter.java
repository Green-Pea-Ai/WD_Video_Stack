package com.example.demo.security.s7;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class VideoJwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public VideoJwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        // 인자로 들어온 URL에서 정보를 보겠다!
        setFilterProcessesUrl(VideoSecurityConstants.AUTH_LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        // 1차각성, 2차각성 워리어 예제의 스프링 확장판
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        VideoCustomUser user = ((VideoCustomUser) authResult.getPrincipal());

        List<String> roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        byte[] signingKey = VideoSecurityConstants.JWT_SECRET.getBytes();

        // 60 * 60 이후 0을 3개 붙여줌
        String token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", VideoSecurityConstants.TOKEN_TYPE)
                .setIssuer(VideoSecurityConstants.TOKEN_AUDIENCE)
                .setSubject("" + user.getVideoMember().getUserNo())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .claim("rol", roles)
                .compact();

        response.addHeader(VideoSecurityConstants.TOKEN_HEADER, VideoSecurityConstants.TOKEN_PREFIX + token);
    }
}
