package com.zlc.springcloudalibabaadmin.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月19日 17:06:00
 */
public class EmailEvent extends ApplicationEvent {

    public EmailEvent(Object source) {
        super(source);
    }
}
