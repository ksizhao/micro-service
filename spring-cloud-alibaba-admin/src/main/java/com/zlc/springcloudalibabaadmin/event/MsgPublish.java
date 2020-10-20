package com.zlc.springcloudalibabaadmin.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月19日 16:33:00
 */
@Service
public class MsgPublish implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;


    public void addEvent(String msg){
        this.publisher.publishEvent(new MsgPublishEvent(msg));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        this.publisher = applicationEventPublisher;
    }
}
