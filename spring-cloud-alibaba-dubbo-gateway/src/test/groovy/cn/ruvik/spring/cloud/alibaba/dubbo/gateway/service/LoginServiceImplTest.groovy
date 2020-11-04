package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.service

import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser
import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.service.impl.LoginServiceImpl
import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.util.JwtTokenUtil
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.algorithms.HMACAlgorithm
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.data.redis.core.StringRedisTemplate
import spock.lang.Specification

/**
 * @author zhaolc* @version 1.0* @createTime 2020年11月03日 17:32:00
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([JwtTokenUtil.class, Algorithm.class, LoginServiceImplTest])
class LoginServiceImplTest extends Specification{

    LoginServiceImpl impl=new LoginServiceImpl()
    StringRedisTemplate redisTemplate=Mock()
    ConfigurableApplicationContext applicationContext=Mock()

    void setup() {
        impl.redisTemplate = redisTemplate
        impl.applicationContext = applicationContext
    }

    def "test login"(){
        given:
        String userName="zlc"
         String password="test"
        when:
        String token="123456789"
        String secret="test"
//        Mockito.when(JwtTokenUtil.createToken(userName, secret)).thenReturn(token)
//        Mockito.when(Algorithm.HMAC512(secret)).thenReturn(new HMACAlgorithm("HS512", "HmacSHA512", secret))
        LoginUser loginUser=impl.login(userName,password)
        then:
        loginUser!=null

    }
}
