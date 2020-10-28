package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.filter;

import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.session.Session;
import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author zhaolc
 * @version 1.0
 * @description 用户认证
 * @createTime 2020年10月17日 16:43:00
 */
@Slf4j
@Service
public class AuthenticationFilter extends AbstractGatewayFilterFactory {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {

            String url = exchange.getRequest().getURI().getPath();
            //跳过不需要验证的路径
            if(Arrays.asList(applicationContext.getEnvironment().getProperty("auth.skip.urls")).contains(url)){
                return chain.filter(exchange);
            }
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // 1. 获取token
            String token = request.getHeaders().getFirst(JwtTokenUtil.AUTH_HEADER_KEY);

            log.info("当前请求的url:{}, method:{}", request.getURI().getPath(), request.getMethodValue());

            //如果是方法探测，直接通过
            if (HttpMethod.OPTIONS.equals(request.getMethod())) {
                response.setStatusCode(HttpStatus.OK);
                return response.setComplete();
            }
            //未携带token
            if (token == null ||
                    token.isEmpty()) {
                ServerHttpResponse originalResponse = getServerHttpResponse(exchange);
                byte[] responseByte = "{\"code\": \"401\",\"msg\": \"401 Unauthorized.\"}"
                        .getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = originalResponse.bufferFactory().wrap(responseByte);
                return originalResponse.writeWith(Flux.just(buffer));
            }
            // 验证token
            String userName;
            try {
                userName= JwtTokenUtil.verifyToken(token,applicationContext.getEnvironment().getProperty("jwt.secret.key"));
                if(userName.isEmpty()){
                    ServerHttpResponse originalResponse = getServerHttpResponse(exchange);
                    byte[] responseByte = "{\"code\": \"10002\",\"msg\": \"invalid token.\"}"
                            .getBytes(StandardCharsets.UTF_8);
                    DataBuffer buffer = originalResponse.bufferFactory().wrap(responseByte);
                    return originalResponse.writeWith(Flux.just(buffer));
                }
            } catch (Exception e) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
            // 3. 将用户名传递给后端服务
            ServerWebExchange build;
            try {
                ServerHttpRequest host = exchange.getRequest().mutate()
                        .header("X-User-Name", userName)
                        // 中文字符需要编码
                        .header("X-Real-Name", URLEncoder.encode(userName, "utf-8"))
                        .build();
                build = exchange.mutate().request(host).build();
            } catch (UnsupportedEncodingException e) {
                build = exchange;
            }
            return chain.filter(build);
        };
    }

    private ServerHttpResponse getServerHttpResponse(ServerWebExchange exchange) {
        ServerHttpResponse originalResponse = exchange.getResponse();
        originalResponse.setStatusCode(HttpStatus.OK);
        originalResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return originalResponse;
    }
}
