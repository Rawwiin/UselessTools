package com.example.uselesstools.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    // 有效时间
    public static final Long JWT_TTL = 60 * 60 * 1000L;
    //设置秘钥明文
    public static final String JWT_KEY = "rawwiin_key";

    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 解析jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * 生成jwt
     *
     * @param uuid
     * @param subject
     * @param ttl
     * @return
     */
    public static String createJwt(String subject, Long ttl, String uuid) {
        JwtBuilder jwtBuilder = getJwtBuilder(subject, ttl, uuid);
        return jwtBuilder.compact();
    }

    public static String createJwt(String subject, String uuid) {
        return createJwt(subject, null, uuid);
    }

    public static String createJwt(String subject, Long ttl) {
        String uuid = createUUID();
        return createJwt(subject, ttl, uuid);
    }

    public static String createJwt(String subject) {
        String uuid = createUUID();
        return createJwt(subject, null, uuid);
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttl, String uuid) {
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + (ttl == null ? JWT_TTL : ttl);
        return Jwts.builder()
                // 唯一ID
                .setId(uuid)
                // 主题
                .setSubject(subject)
                // 签发者
                .setIssuer("Rawwiin")
                // 签发时间
                .setIssuedAt(new Date(nowMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setExpiration(new Date(expMillis));
    }

    private static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
