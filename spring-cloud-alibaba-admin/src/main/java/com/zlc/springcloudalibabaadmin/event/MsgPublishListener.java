package com.zlc.springcloudalibabaadmin.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月19日 16:38:00
 */
@Component
@Slf4j
public class MsgPublishListener  {

    @Async
    @EventListener
    public void onApplicationEvent1(MsgPublishEvent msgPublishEvent) {
        // 监听到对应的事件
        log.info("触发监听事件[{}]",msgPublishEvent.toString());
        log.info("获取信息[{}]",msgPublishEvent.getSource());
    }
    @Async
    @EventListener
    public void onApplicationEvent2(EmailEvent emailEvent) {
        // 监听到对应的事件
        log.info("触发监听事件[{}]",emailEvent.toString());
        log.info("获取信息[{}]",emailEvent.getSource());
    }

}
