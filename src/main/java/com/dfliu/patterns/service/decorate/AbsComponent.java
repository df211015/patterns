package com.dfliu.patterns.service.decorate;

public abstract class AbsComponent extends AbsOilPaint {
    private AbsOilPaint oilPaint;

    public AbsComponent(AbsOilPaint oilPaint) {
        this.oilPaint = oilPaint;
    }

    @Override
    public void paint(String name) {
        this.oilPaint.paint(name);
    }
}
