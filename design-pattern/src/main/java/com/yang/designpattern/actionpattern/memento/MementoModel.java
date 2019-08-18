package com.yang.designpattern.actionpattern.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/8/18 17:46
 * @description: 备忘录模式
 * 情景：文档录入过程中电脑断电，重新打开软件时仍可恢复。
 * 管理系统中对发出的公文进行回撤。
 * 录入一条记录时，发现上一条录入错误，需要恢复上一条的数据。
 * 核心：保存某个对象的状态拷贝，在将来某个时候可以将对象恢复到备份的状态。
 * 结构：
 * 源发器类(Originator)：状态的拷贝源。
 * 备忘录类(Memento)：状态的拷贝副本。
 * 责任人类(CareTake)：持有并存储一系列拷贝的对象，可以用栈数据结构来保存多个还原点，以方便回撤。
 *
 * 用例：棋牌游戏中的悔棋功能，编辑软件中的撤销、恢复到历史版本功能，数据库的事务回滚功能。
 */
public class MementoModel {

    public static void main(String[] args) {
//        once();
        multi();
    }

    /**
     * 单次备份
     */
    public static void once() {
        CareTaker careTaker = new CareTaker();
        //0.初始状态
        Employ employ = new Employ("75", "----yang", 31, 10000D);
        System.out.println(employ.toString());

        //1.保存点备份
        careTaker.setMemento(employ.memento());

        //2.临时修改
        employ.setName("----luo");
        System.out.println(employ.toString());

        //3.撤销到备份点
        employ.recovery(careTaker.getMemento());
        System.out.println(employ.toString());
    }

    /**
     * 多次备份
     */
    public static void multi() {
        CareTaker careTaker = new CareTaker();
        //0.初始状态
        Employ employ = new Employ("75", "----luo", 31, 10000D);
        System.out.println(employ.toString());

        //1.保存点备份
        careTaker.getMementoList().add(employ.memento());

        //2.临时修改
        employ.setName("----luo0");
        System.out.println(employ.toString());

        //3.再次保存点备份
        careTaker.getMementoList().add(employ.memento());

        //4.临时修改
        employ.setName("----luo1");
        System.out.println(employ.toString());

        //3.撤销到备份点
        employ.recovery(careTaker.getMementoList().get(0));
        System.out.println(employ.toString());
    }

}

/**
 * 源发器类
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Employ {

    private String id;

    private String name;

    private int age;

    private double salary;

    /**
     * 备忘操作
     *
     * @return
     */
    public EmployMemento memento() {
        return new EmployMemento(this);
    }

    /**
     * 恢复操作
     */
    public void recovery(EmployMemento memento) {
        this.id = memento.getId();
        this.name = memento.getName();
        this.age = memento.getAge();
        this.salary = memento.getSalary();
    }

}

/**
 * 备忘录类
 */
@Data
class EmployMemento {

    private String id;

    private String name;

    private int age;

    private double salary;

    public EmployMemento(Employ employ) {
        this.id = employ.getId();
        this.name = employ.getName();
        this.age = employ.getAge();
        this.salary = employ.getSalary();
    }
}

/**
 * 负责人类
 */
@Data
class CareTaker {

    /**
     * 一次备份
     */
    private EmployMemento memento;

    /**
     * 多个备份点
     */
    private List<EmployMemento> mementoList = new ArrayList<>();

}