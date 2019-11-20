package com.test.niko;

/**
 * Created by nikoliu on 2019/11/20.
 */
public class People {
    String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("我是 " + this.name);
    }
}
