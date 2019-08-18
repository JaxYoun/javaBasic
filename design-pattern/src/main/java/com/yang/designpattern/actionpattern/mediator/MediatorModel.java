package com.yang.designpattern.actionpattern.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yang
 * @date: 2019/8/17 20:56
 * @description:中介者模式 <p>
 * 背景：系统中的【大量】对象之间由于存在相互通信，极易形成网状的对象关系，各对象形成直接耦合，不利于开发和维护，
 * 解决办法与现实类似，引入一类对象作为中介者，将之前的各对象变为worker中介者成为boss来做协调，解除各对象的直接耦合。
 * 案例：MVC中的控制器，就是一个中介者，不论是对view还是modle的请求都是通过控制器的分派。
 * 各种GUI程序中的组件都是注册到主窗体，然后接受主窗体的动作分派。
 * 事件注册也是如此，由bus担任中介者。
 * java反射中的invoke()方法也使用了中介者模式。
 * </p>
 */
public class MediatorModel {

    public static void main(String[] args) {
        President president = new President();
        new Fiancial(president);
        new Develop(president);

        president.comment("dev", "self");
        president.comment("fina", "outer");
    }

}

/**
 * 中介者对象接口
 */
interface MyMediator {

    /**
     * 接受worker前来注册
     */
    void register(String deptName, Department department);

    /**
     * 向worker发出行为命令
     */
    void comment(String deptName, String commendName);

}

/**
 * 同事类的接口
 */
interface Department {

    /**
     * 部门内的行为
     */
    void selfAction();

    /**
     * 部门间的行为
     */
    void outerAction();

}

/**
 * 部门抽象类
 */
abstract class AbstractDepartment implements Department {

    /**
     * 汇聚到的中介者
     */
    protected MyMediator myMediator;

}

/**
 * 开发部
 */
class Develop extends AbstractDepartment {

    public Develop(MyMediator myMediator) {
        super();
        super.myMediator = myMediator;
        myMediator.register("dev", this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心开发！");
    }

    @Override
    public void outerAction() {
        System.out.println("给开发部拨款！");
    }
}

/**
 * 财务部
 */
class Fiancial extends AbstractDepartment {

    public Fiancial(MyMediator myMediator) {
        super();
        super.myMediator = myMediator;
        myMediator.register("fina", this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心数钱！");
    }

    @Override
    public void outerAction() {
        System.out.println("拨款！");
    }
}

class President implements MyMediator {

    private Map<String, Department> map = new HashMap<>();

    @Override
    public void register(String deptName, Department department) {
        this.map.put(deptName, department);
    }

    @Override
    public void comment(String deptName, String commendName) {
        Department department = this.map.get(deptName);
        assert department != null;
        if("self".equals(commendName)) {
            department.selfAction();
        } else {
            department.outerAction();
        }
    }
}


