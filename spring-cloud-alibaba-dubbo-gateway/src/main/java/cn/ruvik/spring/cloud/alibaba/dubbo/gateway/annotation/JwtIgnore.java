package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaolc
 * @version 1.0
 * @description 不需要验证token
 * @createTime 2020年10月27日 09:11:00
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtIgnore {
    boolean value() default true;
}
