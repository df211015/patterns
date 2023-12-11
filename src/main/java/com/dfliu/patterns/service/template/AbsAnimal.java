package com.dfliu.patterns.service.template;

public abstract class AbsAnimal {
    public abstract String getAnimalName();

    public void showAnimalInfo() {
        String animalName = this.getAnimalName();
        System.out.println(String.format("动物的名称:%s",animalName));
    }
}
