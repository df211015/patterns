package com.dfliu.patterns.service.decorate;

public class Polish extends AbsComponent {
    public Polish(AbsOilPaint oilPaint) {
        super(oilPaint);
    }

    @Override
    public void paint(String name) {
        this.doPolish(name);
        super.paint(name);
    }

    private void doPolish(String name) {
        System.out.println(String.format("%s,打磨墙面已完成", name));
    }
}
