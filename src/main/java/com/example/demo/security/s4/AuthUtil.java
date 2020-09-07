package com.example.demo.security.s4;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class AuthUtil {
    // static은 New를 안해도 쓸 수 있다.
    // Header 정보를 날릴때 jwt 형식의 데이터를 날려서 식별할 수 있게 해야 한다.(엔코딩?)
    public static long getUserNo(String header) throws Exception {
        String token = header.substring(7);

        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

        // parsedToken은 아래의 subject까지 포함하여 디코딩된 데이터를 얻는다.(20라인까지 보면됨)
        Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token);

        String subject = parsedToken.getBody().getSubject();

        long userNo = Integer.parseInt(subject);

        return userNo;
    }
}
