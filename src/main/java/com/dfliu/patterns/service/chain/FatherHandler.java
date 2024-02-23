package com.dfliu.patterns.service.chain;

import com.dfliu.patterns.domain.constants.ResponseType;

public class FatherHandler extends Handler {
    public FatherHandler() {
        super(ResponseType.FATHER.getCode(), 10);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("---女儿向父亲的请求---");
        System.out.println(women.getRequest());
        System.out.println(String.format("父亲的回复是:%s", "同意"));
    }
}
