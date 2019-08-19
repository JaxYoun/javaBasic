package com.yang.designpattern.creationpattern.singleton;

/**
 * @author: Yang
 * @date: 2019/8/18 23:21
 * @description: 饿汉式：类初始化时立即加载，并完成实例对象的初始化，如果在后续系统中并没有使用该对象，就造成了资源的浪费。
 */
public class HungryModel {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(HungrySingleton.getInstance() == HungrySingleton.getInstance());
        }
    }
}

/**
 *
 */
class HungrySingleton {

    /**
     * 0.持有对象作为，此处的实例化是天生线程安全的
     */
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 1.私有化类的构造器
     */
    private HungrySingleton() {
    }

    /**
     * 2.提供外部访问入口，由于实例化过程天生线程安全，所以此方法不需要做同步处理，不同步调用效率更高
     *
     * @return
     */
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
