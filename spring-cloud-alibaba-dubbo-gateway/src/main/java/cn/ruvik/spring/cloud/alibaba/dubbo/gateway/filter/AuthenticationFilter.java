package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.filter;

import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.session.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
    private Session session;
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // 1. 获取token
            String token = request.getHeaders().getFirst("token");

            log.info("当前请求的url:{}, method:{}", request.getURI().getPath(), request.getMethodValue());

            if (Strings.isEmpty(token)) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            // 2. 验证用户是否已登陆
            LoginUser loginUser = this.session.getSession(token);
            if (loginUser == null) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            // 3. 将用户名传递给后端服务
            ServerWebExchange build;
            try {
                ServerHttpRequest host = exchange.getRequest().mutate()
                        .header("X-User-Name", loginUser.getUserName())
                        // 中文字符需要编码
                        .header("X-Real-Name", URLEncoder.encode(loginUser.getRealName(), "utf-8"))
                        .build();
                build = exchange.mutate().request(host).build();
            } catch (UnsupportedEncodingException e) {
                build = exchange;
            }
            return chain.filter(build);
        };
    }
}
