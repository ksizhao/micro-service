package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

import java.util.Date;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月26日 17:55:00
 */
public class JwtTokenUtil {
    //定义token返回头部
    public static final String AUTH_HEADER_KEY = "Authorization";

    //token前缀
    public static final String TOKEN_PREFIX = "Bearer";

    //签名密钥
    public static final String KEY = "q3t6w9z$C&F)J@NcQfTjWnZr4u7x";

    //有效期默认为 2hour
    public static final Long EXPIRATION_TIME = 1000L*60*60*2;

    /**
     * 创建TOKEN
     * @param content
     * @return
     */
    public static String createToken(String content,String secretKey){
        return JWT.create()
                .withSubject(content)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(secretKey));
    }

    /**
     * 验证token
     * @param token
     */
    public static String verifyToken(String token,String secretKey) throws Exception {
        try {
            return JWT.require(Algorithm.HMAC512(secretKey))
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (TokenExpiredException e){
            throw new Exception("token已失效，请重新登录",e);
        } catch (JWTVerificationException e) {
            throw new Exception("token验证失败！",e);
        }
    }

}
