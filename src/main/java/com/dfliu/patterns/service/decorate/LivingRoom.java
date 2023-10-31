package com.dfliu.patterns.service.decorate;

public class LivingRoom extends AbsOilPaint {
    @Override
    public void paint(String name) {
        System.out.println(String.format("%s,客厅可以开始油漆了", name));
    }
}