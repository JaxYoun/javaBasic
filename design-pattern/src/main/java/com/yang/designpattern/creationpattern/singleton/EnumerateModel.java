package com.yang.designpattern.creationpattern.singleton;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/8/19 23:18
 * @description: 枚举式：具有线程安全、调用高效两个优点，【不支持延迟加载】，但是实现极为优雅简洁。
 * 【可防止反射攻击和序列化攻击】
 */
public class EnumerateModel {

    public static void main(String[] args) {
        Server.INSTANCE.go();
    }

}

enum Server {

    /**
     * 实例对象
     */
    INSTANCE;

    private static final List<String> list = new ArrayList<>(5);

    public void go() {
        list.add("88");
        list.add("99");
        list.add("00");
        list.forEach(System.out::println);
    }

}