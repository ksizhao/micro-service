package com.sankuai.inf.leaf.common;

import com.sankuai.inf.leaf.IDGen;
import fingard.entity.Result;
import fingard.entity.Status;

public class ZeroIDGen implements IDGen {
    @Override
    public Result get(String key) {
        return new Result(0, Status.SUCCESS);
    }

    @Override
    public boolean init() {
        return true;
    }
}
