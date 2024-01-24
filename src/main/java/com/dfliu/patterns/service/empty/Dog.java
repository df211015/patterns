package com.dfliu.patterns.service.empty;

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println(String.format("make sound,from:%s", this.getClass().toString()));
    }
}
