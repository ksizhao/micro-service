package com.zlc.springcloudalibabaadmin.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月19日 16:34:00
 */
public class MsgPublishEvent extends ApplicationEvent {

    private static final long serialVersionUID = -3515566087431586861L;

    public MsgPublishEvent(Object source) {
        super(source);
    }
}
