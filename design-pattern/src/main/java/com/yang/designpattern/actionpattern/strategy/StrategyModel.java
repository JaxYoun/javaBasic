package com.yang.designpattern.actionpattern.strategy;

/**
 * @author: Yang
 * @date: 2019/8/18 12:05
 * @description: 策略模式
 * 定义：策略模式对应解决某一问题的算法簇，允许用户从簇中选择一个算法来解决问题，同时可以方便的更换或新增算法，
 * 并且由客户端来决定算法的选择。
 * 本质：分离算法和选择的实现。
 * 场景：使用if-else或switch-case也可以达到同样的目的，但是当业务比较复杂时代码量会非常大不利于维护，
 * 如果要实现逻辑扩展，必须修改旧代码，违背了开闭原则。
 * 用例：java之GUI中主题的选择，Spring中Resource接口的资源访问策略，Servlet中的service()方法。
 */
public class StrategyModel {

    public static void main(String[] args) {
        OldMany oldMany = new OldMany();
        Context context = new Context(oldMany);
        context.printPrice(100D);
    }

}

/**
 * 一头连接客户端，同时负责和具体的策略类交互，这样算法和客户端就解耦了，使得算法独立于客户端的变化。
 */
class Context {

    /**
     * 当前采用的算法，可以采用构造注入、setter注入、ioc容器注入
     */
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double originPrice) {
        System.out.println("========" + this.strategy.getPrice(originPrice));
    }

}

/**
 * 策略接口，构成算法簇
 */
interface Strategy {

    /**
     * 获取价格接口
     *
     * @param originPrice
     * @return
     */
    double getPrice(double originPrice);

}

/**
 * 小批量新用户，打九折
 */
class NewFew implements Strategy {

    @Override
    public double getPrice(double originPrice) {
        System.out.println("小批量新用户，打九折");
        return originPrice * 0.9D;
    }

}

/**
 * 小批量老用户，八五折
 */
class OldFew implements Strategy {

    @Override
    public double getPrice(double originPrice) {
        System.out.println("小批量老用户，八五折");
        return originPrice * 0.85D;
    }

}

/**
 * 大批量老用户，七五折
 */
class NewMany implements Strategy {

    @Override
    public double getPrice(double originPrice) {
        System.out.println("大批量新用户，七五折");
        return originPrice * 0.75D;
    }

}

/**
 * 大批量老用户，七折
 */
class OldMany implements Strategy {

    @Override
    public double getPrice(double originPrice) {
        System.out.println("大批量老用户，七折");
        return originPrice * 0.7D;
    }

}
