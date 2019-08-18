package com.yang.designpattern.creationpattern.singleton;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author: Yang
 * @date: 2019/8/18 23:21
 * @description: 饿汉式
 *
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

    //0.持有对象作为
    private static final HungrySingleton ISTANCE = new HungrySingleton();

    //1.私有化构造器
    private HungrySingleton() {}

    //2.提供外部访问入口
    synchronized public static HungrySingleton getInstance() {
        return ISTANCE;
    }
}
