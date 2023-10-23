package com.dfliu.patterns.service.builder;

public class ABuilder extends AbsBuilder {
    @Override
    public void buildDecrorateHouse() {
        System.out.println("装修储物间->装修阳台->装修卧室");
        super.setCloset("装修储物间");
        super.setBalcony("装修阳台");
        super.setBedroom("装修卧室");
    }
}
