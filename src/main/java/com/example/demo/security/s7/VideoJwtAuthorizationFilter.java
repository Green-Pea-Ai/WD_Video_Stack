package com.example.demo.security.s7;

// import com.example.demo.security.s4.JwtAuthenticationFilter;
// import com.example.demo.security.s4.SecurityConstants;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

// JWT: JSON Web Token
// JWS: JSON Web Signature(JSON 웹 서명)
public class VideoJwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(VideoJwtAuthenticationFilter.class);

    public VideoJwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        // 요청을 통해 Authentication을 얻어 오려고 함
        Authentication authentication = getAuthentication(request);
        String header = request.getHeader(VideoSecurityConstants.TOKEN_HEADER);

        // header가 비어있으면 || 다음 코드는 연산하지 않고 바로 밑으로 내려간다
        if(isEmpty(header) || !header.startsWith(VideoSecurityConstants.TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);

            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(VideoSecurityConstants.TOKEN_HEADER);

        // 여기서 token은 문자열을 의미. 문자열이 Null인지 아닌지를 판단
        if (isNotEmpty(token)) {
            try {
                byte[] siginingKey = VideoSecurityConstants.JWT_SECRET.getBytes();

                // JwTtEsT -> Bearer
                Jws<Claims> parsedToken = Jwts.parser()
                        .setSigningKey(siginingKey)
                        .parseClaimsJws(token.replace("Bearer ", ""));

                String username = parsedToken
                        .getBody()
                        .getSubject();

                // ((List<?>)의 ?는 와일드카드라고 함: 데이터를 가리지 않고 다 받겠다.
                List<SimpleGrantedAuthority> simpleGrantedAuthorityList = ((List<?>) parsedToken.getBody()
                        .get("rol")).stream()
                        .map(authority -> new SimpleGrantedAuthority((String) authority))
                        .collect(Collectors.toList());

                if(isNotEmpty(username)) {
                    return new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorityList);
                }
            } catch (ExpiredJwtException exception) {
                log.warn("Request to parse expired JWT : {} failed : {}", token, exception.getMessage());
            } catch (UnsupportedJwtException exception) {
                log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
            } catch (MalformedJwtException exception) {
                log.warn("Request to parse invalid JWT : {} failed : {}", token, exception.getMessage());
            } catch (SignatureException exception) {
                log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
            } catch (IllegalArgumentException exception) {
                log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
            }
        }
        return null;
    }

    private boolean isEmpty(final CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private boolean isNotEmpty(final CharSequence charSequence) {
        return !isEmpty(charSequence);
    }
}










