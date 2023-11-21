package com.dfliu.patterns.service.chain;

import com.dfliu.patterns.domain.constants.ResponseType;

public class HusbandHandler extends Handler {
    public HusbandHandler() {
        super(ResponseType.HUSBAND.getCode());
    }

    @Override
    public void response(IWomen women) {
        System.out.println(String.format("妻子向丈夫的请求:%s", women.getRequest()));
        System.out.println(String.format("丈夫的回复是:%s", "同意"));
    }
}
