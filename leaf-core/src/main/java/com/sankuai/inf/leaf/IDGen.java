package com.sankuai.inf.leaf;


import fingard.entity.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}
