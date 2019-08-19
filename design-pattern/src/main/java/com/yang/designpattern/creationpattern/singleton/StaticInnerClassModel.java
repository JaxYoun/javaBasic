package com.yang.designpattern.creationpattern.singleton;

/**
 * @author: Yang
 * @date: 2019/8/19 23:02
 * @description: 静态内部类式：兼具延迟加载、线程安全、高效调用三个优点，同时实现也很简洁优雅。
 */
public final class StaticInnerClassModel {

    /**
     * 0.私有化构造器
     */
    private StaticInnerClassModel() {
    }

    /**
     * 1.外部调用入口，无同步操作高效调用
     *
     * @return
     */
    public static StaticInnerClassModel getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 2.由静态内部类的初始化机制决定，jvm加载外部类时不会加载内部类，真正第一次调用时才会加载，进而完成对象的实例化
     */
    private static class Holder {

        /**
         * 3.实例化过程是延迟的，且由jvm机制决定它天然是线程安全的
         */
        private static final StaticInnerClassModel INSTANCE = new StaticInnerClassModel();
    }

}
