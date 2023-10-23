package com.dfliu.patterns.service.builder;

import com.dfliu.patterns.domain.dto.DecrorateHouse;

public abstract class AbsBuilder {
    private DecrorateHouse house = new DecrorateHouse();

    public DecrorateHouse getHouse() {
        this.buildDecrorateHouse();
        return this.house;
    }

    public void setCloset(String closet) {
        this.house.setCloset(closet);
    }

    public void setBalcony(String balcony) {
        this.house.setBalcony(balcony);
    }

    public void setBedroom(String bedroom) {
        this.house.setBedroom(bedroom);
    }

    public abstract void buildDecrorateHouse();
}
