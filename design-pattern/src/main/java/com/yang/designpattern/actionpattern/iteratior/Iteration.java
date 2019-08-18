package com.yang.designpattern.actionpattern.iteratior;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/8/17 12:36
 * @description:迭代器模式 <p>
 * 场景：提供一种可以遍历聚合对象的方式，也成为游标模式，其中聚合对象用于存储数据元素、迭代器对象用于遍历元素。
 * 实现：聚合对象向客户端提供迭代器对象，通常将迭代器类定义为聚合类的内部类，方便访问聚合类的属性，迭代器类通常是专有的。
 * 优点：将遍历元素时的下标移动封装到迭代器对象中，对上层做了隐藏，符合迪米特法则。
 * 可以实现正向遍历、逆向遍历，典型的例子就是jdk的集合类库。
 * </p>
 */
public class Iteration {

    public static void main(String[] args) {
        MyAggregate<String> aggregate = new MyAggregate<>();
        aggregate.add("aa");
        aggregate.add("bb");
        aggregate.add("cc");
        aggregate.add("dd");

        MyIterator<String> it = aggregate.getMyIterator();
        while (it.hasNext()) {
            System.out.println(it.getNext());
            it.next();
        }

    }

}

class MyAggregate<T> {

    private List<T> list = new ArrayList<>();

    public MyIterator<T> getMyIterator() {
        return new MyIterration();
    }

    public boolean add(T element) {
        return this.list.add(element);
    }

    public boolean remove(T element) {
        return this.list.remove(element);
    }

    public T remove(int i) {
        return this.list.remove(i);
    }

    private class MyIterration implements MyIterator<T> {

        private int cursor;

        @Override
        public int current() {
            return cursor;
        }

        @Override
        public int first() {
            return 0;
        }

        @Override
        public void next() {
            if (cursor < list.size()) {
                cursor++;
            }
        }

        @Override
        public int last() {
            return list.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor == list.size() - 1;
        }

        @Override
        public T getNext() {
            return list.get(cursor);
        }
    }

}

/**
 * 自定义迭代器接口
 *
 * @param <T>
 */
interface MyIterator<T> {

    /**
     * 将游标指向当前元素
     *
     * @return
     */
    int current();

    /**
     * 将游标指向第一个元素
     *
     * @return
     */
    int first();

    boolean isFirst();

    /**
     * 将游标指向下一个元素
     *
     * @return
     */
    void next();

    /**
     * 将游标指向最后元素
     *
     * @return
     */
    int last();

    boolean isLast();

    /**
     * 判断是否存在下一个元素
     *
     * @return
     */
    boolean hasNext();

    T getNext();

}
