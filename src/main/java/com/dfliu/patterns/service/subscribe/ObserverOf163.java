package com.dfliu.patterns.service.subscribe;

import java.util.Observable;
import java.util.Observer;

public class ObserverOf163 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String mobile = (String) arg;
        System.out.println(String.format("接受者:ObserverOf163,开始update, 入参:%s", mobile));
    }
}
