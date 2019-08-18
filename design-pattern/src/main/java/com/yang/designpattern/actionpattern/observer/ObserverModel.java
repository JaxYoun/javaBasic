package com.yang.designpattern.actionpattern.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/8/18 15:30
 * @description: 观察者模式
 * 场景：发布-订阅型，其中订阅者或者消费者称作观察者，发布者被称为目标，它观察发布者的状态变化。
 * 核心：观察者模式多用于1：N的通信模式，当目标（Observable）的状态发生变化时，它要及时告知一系列观察者对象（Observer），令其做出响应。
 * 推模式：每次都将消息以广播的方式发送给观察者，所有观察者只能被动接收。
 * 拉模式：观察者只需要知道目标有状态变化即可，至于何时获取内容、获取什么内容都由观察者决定。
 *
 * 用例：聊天、广播、邮件订阅、ServletListener、Android广播、JDK中AWT事件处理模型，基于观察者模式的委派事件机制
 */
public class ObserverModel {

    public static void main(String[] args) {
        IObserver observer = new ObserverOne();
        IObserver observer0 = new ObserverOne();
        IObserver observer1 = new ObserverOne();
        IObserver observer2 = new ObserverOne();

        ParentObservable sonObservable = new SonObservable();
        sonObservable.regist(observer);
        sonObservable.regist(observer0);
        sonObservable.regist(observer1);
        sonObservable.regist(observer2);

        sonObservable.changeState(1);
        sonObservable.changeState(2);
        sonObservable.changeState(3);
    }

}

/**
 * 观察者接口
 */
interface IObserver {

    /**
     * 观察者的响应动作
     */
    void update(ParentObservable observable);

}

/**
 * 观察者实现类
 */
class ObserverOne implements IObserver {

    /**
     * 观察者的状态，需要实时和被观察者保持一致
     */
    private int myState;

    @Override
    public void update(ParentObservable observable) {
        System.out.println("我被通知了，我的当前状态是：" + this.myState);
        this.myState = observable.getState();
        System.out.println("我的状态改变了，我的当前状态是：" + this.myState);
    }
}

/**
 * 被观察者父类
 */
@Data
abstract class ParentObservable {

    protected int state;

    /**
     * 用于盛放注册上来的多个观察者
     */
    protected List<IObserver> observerList = new ArrayList<>();

    /**
     * 接受注册
     *
     * @param observer
     */
    public void regist(IObserver observer) {
        this.observerList.add(observer);
    }

    /**
     * 解除注册
     *
     * @param observer
     */
    public void remove(IObserver observer) {
        this.observerList.remove(observer);
    }

    /**
     * 向全体观察者发出广播
     */
    protected void speakToAll() {
        this.observerList.forEach(it -> it.update(this));
    }

    /**
     *
     * @param i
     */
    abstract void changeState(int i);

}

/**
 * 被观察者子类
 */
class SonObservable extends ParentObservable {

    @Override
    public void changeState(int i) {
        super.state = i;
        super.speakToAll();
    }

}
