package com.yang.designpattern.creationpattern.factory;

/**
 * @author: Yang
 * @date: 2019/8/25 17:57
 * @description:简单工厂模式（也叫静态工厂模式），最简单也最常用。用于生产同一等级结构的任意对象。（小缺点：对于新增的产品类型，需要修改已有代码）
 */
public class SimpleFactoryModel {

    public static void main(String[] args) {
        SimpleCarFactoryOne.createCar("bmw").run();
        SimpleCarFactoryOne.createCar("audi").run();

        SimpleCarFactoryTwo.createBmw().run();
        SimpleCarFactoryTwo.createAudi().run();
    }
}

/**
 * 第一种简单汽车工厂
 */
class SimpleCarFactoryOne {

    public static Car createCar(String name) {
        switch (name) {
            case "bmw": {
                return new Bmw();
            }
            case "audi": {
                return new Audi();
            }
            default: {
                return null;
            }
        }
    }
}

/**
 * 第二种简单汽车工厂
 */
class SimpleCarFactoryTwo {
    public static Car createBmw() {
        return new Bmw();
    }

    public static Car createAudi() {
        return new Audi();
    }
}

/**
 * 产品接口
 */
interface Car {
    void run();
}

/**
 * 产品实现类BMW
 */
class Bmw implements Car {
    @Override
    public void run() {
        System.out.println("宝马在跑-------");
    }
}

/**
 * 产品实现类Audi
 */
class Audi implements Car {
    @Override
    public void run() {
        System.out.println("奥迪在跑-------");
    }
}