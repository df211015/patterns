package com.dfliu.patterns.service.subscribe;

import java.util.Observable;

/**
 * 被观察者角色
 */
public class SubjectOf163 extends Observable implements ISubject {

    /**
     * @param mobile 手机号
     */
    @Override
    public void sendCheckCode(String mobile) {
        System.out.println(String.format("请求手机验证码:xxxxxx,手机号:%s", mobile));
        super.setChanged();
        super.notifyObservers(mobile);
    }
}
