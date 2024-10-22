package com.sparta.gathering.common.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import com.sparta.gathering.common.exception.ServerException;
import com.sparta.gathering.domain.user.enums.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Slf4j(topic = "JwtUtil")
@Component
public class JwtTokenProvider {

    // private static final long TOKEN_TIME = 60 * 60 * 1000L; // 60분
    private static final long TOKEN_TIME = 7 * 24 * 60 * 60 * 1000L; // 7일
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; // 암호화 알고리즘
    private static final String BEARER_PREFIX = "Bearer "; // Bearer 접두어
    public static final String EMAIL_CLAIM = "email"; // 이메일 클레임
    public static final String NICKNAME_CLAIM = "nickName"; // 닉네임 클레임
    public static final String USER_ROLE_CLAIM = "userRole"; // 유저 권한 클레임

    @Value("${jwt.secret}")
    private String secretKey;
    private Key key;

    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        key = Keys.hmacShaKeyFor(bytes);
    }

    public String createToken(UUID uuid, String email, String nickname , UserRole userRole) {
        Date date = new Date();

        return BEARER_PREFIX +
                Jwts.builder()
                        .setSubject(uuid.toString())
                        .claim(EMAIL_CLAIM, email)
                        .claim(NICKNAME_CLAIM, nickname)
                        .claim(USER_ROLE_CLAIM, userRole.name())
                        .setExpiration(new Date(date.getTime() + TOKEN_TIME))
                        .setIssuedAt(date) // 발급일
                        .signWith(key, signatureAlgorithm) // 암호화 알고리즘
                        .compact();
    }

    public String substringToken(String tokenValue) {
        if (StringUtils.hasText(tokenValue) && tokenValue.startsWith(BEARER_PREFIX)) {
            return tokenValue.substring(7);
        }
        throw new ServerException("토큰이 존재하지 않습니다.");
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
