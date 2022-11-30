package com.real.realoasis.global.security;

import com.real.realoasis.global.security.authentication.AuthDetailsService;
import com.real.realoasis.global.security.properties.JwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final long ACCESS_TOKEN_EXPIRED_TIME = 2 * 60 * 1000; // 2시간
    private final long REFRESH_TOKEN_EXPIRED_TIME = 7 * 24 * 60 * 60 * 1000; // 1주

    @AllArgsConstructor
    enum TokenType{
        ACCESS_TOKEN("accessToken"),
        REFRESH_TOKEN("refreshToken");

        private final String value;
    }

    private Key getSignInKey(String secretKey) {
        String key = secretKey + "as-12939gjbkavlllclj$2sd";
        byte[] keyByte = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public Claims extractAllClaims(String token) throws ExpiredJwtException, IllegalStateException, UnsupportedOperationException {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey(jwtProperties.getKey()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 토큰 생성
    // userPk == email
    public String createToken(String userPk, TokenType tokenType, Long expireTime){
        Claims claims = Jwts.claims().setSubject(userPk); // JWT payload 에 저장되는 정보단위
        claims.put("tokenType", tokenType.value); // 정보는 key / value 쌍으로 저장

        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(new Date(System.currentTimeMillis())) // 토큰 발행 시간 정보
                .setExpiration(new Date(System.currentTimeMillis() + expireTime)) // 토큰 유효시간 설정
                .signWith(getSignInKey(jwtProperties.getKey())) // 암호화 알고리즘과 secret 값
                .compact();
    }

    public String generateAccessToken(String userPk) {
        return createToken(userPk, TokenType.ACCESS_TOKEN, ACCESS_TOKEN_EXPIRED_TIME);
    }

    public String generateRefreshToken(String userPk) {
        return createToken(userPk, TokenType.REFRESH_TOKEN, REFRESH_TOKEN_EXPIRED_TIME);
    }
    // 인증 정보 조회
    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰에서 회원 정보 추출
    private String getUserPk(String token) {
        return extractAllClaims(token).getSubject();
    }

    // 토큰 유효성, 만료일자 확인
    public boolean validateToken(String token){
        try {
            return extractAllClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Request Header 에서 token 값 가져오기
    public String resolveToken(HttpServletRequest request){
        return request.getHeader("Authorization");
    }
}
