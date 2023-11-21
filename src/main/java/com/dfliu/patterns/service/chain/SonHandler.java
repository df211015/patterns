package com.dfliu.patterns.service.chain;

import com.dfliu.patterns.domain.constants.ResponseType;

public class SonHandler extends Handler {
    public SonHandler() {
        super(ResponseType.SON.getCode());
    }

    @Override
    public void response(IWomen women) {
        System.out.println("---母亲向儿子的请求---");
        System.out.println(women.getRequest());
        System.out.println(String.format("儿子的回复是:%s", "同意"));
    }
}
