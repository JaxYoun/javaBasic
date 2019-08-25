package com.yang.designpattern.creationpattern.factory;

/**
 * @author: Yang
 * @date: 2019/8/25 18:47
 * @description: 抽象工厂模式，用以生产不同产品族的全部产品（对于增加新的部件产品无能为力，支持增加完整的新产品族）。
 */
public class AbstractFactoryModel {
    public static void main(String[] args) {
        new LuxuryTruckFactory();
        new LowTruckFactory();
    }
}

/**
 * 引擎接口
 */
interface Engine {
    void start();

    void run();
}

class LuxuryEngine implements Engine {
    @Override
    public void start() {
        System.out.println("启动快");
    }

    @Override
    public void run() {
        System.out.println("跑得快");
    }
}

class LowEngine implements Engine {
    @Override
    public void start() {
        System.out.println("启动慢");
    }

    @Override
    public void run() {
        System.out.println("跑得慢");
    }
}

/**
 * 座椅接口
 */
interface Site {
    void messige();
}

class LuxurySite implements Site {
    @Override
    public void messige() {
        System.out.println("我是高端座椅");
    }
}

class LowSite implements Site {
    @Override
    public void messige() {
        System.out.println("我是低端座椅");
    }
}

/**
 * 轮胎接口
 */
interface Tyre {
    void revolve();
}

/**
 * 高端轮胎
 */
class LuxuryTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("超耐久");
    }
}

/**
 * 低端轮胎
 */
class LowTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("不耐久");
    }
}

//-------------------------

/**
 * 汽车工厂类
 */
interface TruckFactory {
    Engine createEngine();

    Site createSite();

    Tyre createTyre();
}

class LuxuryTruckFactory implements TruckFactory {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Site createSite() {
        return new LuxurySite();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}

class LowTruckFactory implements TruckFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Site createSite() {
        return new LowSite();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}