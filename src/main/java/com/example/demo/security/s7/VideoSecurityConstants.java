package com.example.demo.security.s7;

// 상수 값들 모여 있는 곳
public class VideoSecurityConstants {
    public static final String AUTH_LOGIN_URL = "/api/authenticate";

    // http://www.allkeysgenerator.com
    public static final String JWT_SECRET = "%C*F-JaNdRgUkXp2s5v8y/B?E(G+KbPeShVmYq3t6w9z$C&J@McQfTjWnZr4u7x!";

    // JWT 기본 토큰
    public static final String TOKEN_HEADER = "Authorization";

    // JwTtEsT > Bearer 로 바꿈
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
}
