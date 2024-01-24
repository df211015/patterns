package com.dfliu.patterns.service.empty;

public class NullAnimal implements Animal {
    @Override
    public void makeSound() {
        System.out.println(String.format("null,from:%s", this.getClass().toString()));
    }
}
