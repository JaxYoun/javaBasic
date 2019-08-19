package com.yang.designpattern.creationpattern.singleton;

/**
 * @author: Yang
 * @date: 2019/8/19 22:38
 * @description: 懒汉式：只有对象被使用时，才会初始化，延迟加载避免了资源的浪费。
 */
public class LazyModel {

    /**
     * 0.持有全局的对象引用，先不实例化，只有真正用的时候再初始化，它的实例化过程是非线程安全的，要考虑并发场景下的可见性
     */
    volatile private static LazyModel INSTANCE;

    /**
     * 1.私有化类的构造器
     */
    private LazyModel() {
    }

    /**
     * 2.由于实例化过程是非线程安全的，所以需要对构造过程做同步处理，同步会【降低调用效率】
     *
     * @return
     */
    synchronized public static LazyModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyModel();
        }
        return INSTANCE;
    }
}
