package com.example.demo.config;


import com.example.demo.security.s7.VideoCustomAccessDeniedHandler;
import com.example.demo.security.s7.VideoCustomUserDetailsService;
import com.example.demo.security.s7.VideoJwtAuthenticationFilter;
import com.example.demo.security.s7.VideoJwtAuthorizationFilter;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Log
// 웹 보안 관련 방어 기능 활성화
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class VideoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        log.info("Security Configuration!");

        // 이 부분을 자세히 파고 들어가면 너무 빡세지니 간단하게만 보면
        // 접근 거부, URL 요청이 올바른지
        // 권한을 가지고 있는지 등등을 설정하는 것이라 보면 됨
        httpSecurity.cors()
                .and()
                .csrf().disable()
                .exceptionHandling()
                // 토큰 없으면 접근을 거부하게 하는 코드
                // 커스텀 구간 createAccessDeniedHandler
                .accessDeniedHandler(createAccessDeniedHandler())
                .and()
                // 필터
                // 커스텀 구간 JwtAuthenticationFilter
                .addFilter(new VideoJwtAuthenticationFilter(authenticationManager()))
                .addFilter(new VideoJwtAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // 비밀번호를 암호화 하기 위한 설정
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(createUserDetailsService())
                .passwordEncoder(createPasswordEncoder());
    }
    // 커스텀 요소 중 하나
    @Bean
    public UserDetailsService createUserDetailsService() {
        return new VideoCustomUserDetailsService();
    }
    // 커스텀 요소 중 하나
    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 어떠한 형식의 URL 요청이나 Header요청이든 수용하도록 만든다.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowCredentials(true);
        corsConfig.addAllowedOrigin("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.addAllowedMethod("OPTIONS");
        corsConfig.addAllowedMethod("HEAD");
        corsConfig.addAllowedMethod("GET");
        corsConfig.addAllowedMethod("PUT");
        corsConfig.addAllowedMethod("POST");
        corsConfig.addAllowedMethod("DELETE");
        corsConfig.addAllowedMethod("PATCH");
        corsConfig.setExposedHeaders(Arrays.asList("Authorization", "Content-Disposition"));

        source.registerCorsConfiguration("/**", corsConfig);

        return source;
    }

    // 접근 거부와 관련된 생성자
    // 커스텀 요소 중 하나
    @Bean
    public AccessDeniedHandler createAccessDeniedHandler() {
        return new VideoCustomAccessDeniedHandler();
    }
}
