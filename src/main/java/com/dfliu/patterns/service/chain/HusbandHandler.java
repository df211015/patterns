package com.dfliu.patterns.service.chain;

import com.dfliu.patterns.domain.constants.ResponseType;

public class HusbandHandler extends Handler {
    public HusbandHandler() {
        super(ResponseType.HUSBAND.getCode(), 20);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("---妻子向丈夫的请求---");
        System.out.println(women.getRequest());
        System.out.println(String.format("丈夫的回复是:%s", "同意"));
    }
}
