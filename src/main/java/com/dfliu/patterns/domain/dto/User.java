package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return String.format("name:%s,age:%s", this.name, this.age);
    }
}