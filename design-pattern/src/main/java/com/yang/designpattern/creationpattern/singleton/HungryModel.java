package com.yang.designpattern.creationpattern.singleton;

/**
 * @author: Yang
 * @date: 2019/8/18 23:21
 * @description: 饿汉式：类初始化时立即加载，并完成实例对象的初始化，如果在后续系统中并没有使用该对象，就造成了资源的浪费（无法严格控制实例化的时机）。
 * 不能保证在getInstance方法首次被调用时才初始化实例的原因：
 * 1.由于instance对象是静态变量。
 * 2.类的加载过程中的初始化阶段会初始化类的静态变量。
 * 3.类的加载机制规定，类的初始化动作发生在类被主动调用时。
 * 4.比如类中包括其他静态字段，一旦这个静态字段被调用，就会触发实例的初始化。
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
