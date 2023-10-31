package com.dfliu.patterns.service.decorate;

public class Putty extends AbsComponent {

    public Putty(AbsOilPaint oilPaint) {
        super(oilPaint);
    }

    @Override
    public void paint(String name) {
        this.doPutty(name);
        super.paint(name);
    }

    private void doPutty(String name) {
        System.out.println(String.format("%s,墙面刮腻子已完成", name));
    }
}
