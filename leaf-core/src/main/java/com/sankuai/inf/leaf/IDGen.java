package com.sankuai.inf.leaf;


import cn.ruvik.spring.cloud.alibaba.dubbo.entity.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}
