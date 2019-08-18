package com.yang.designpattern.actionpattern.observer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: Yang
 * @date: 2019/8/18 17:16
 * @description: JDK内置的观察者模式
 * JDK为我们提供了Observer接口和Observable父类，方便我们是先自己的观察者模型。
 */
public class JdkObserverModel {

    public static void main(String[] args) {
        //1.初始化一系列观察者
        ObserverTwo observerTwo = new ObserverTwo();
        ObserverTwo observerTwo0 = new ObserverTwo();
        ObserverTwo observerTwo1 = new ObserverTwo();
        ObserverTwo observerTwo2 = new ObserverTwo();
        ObserverTwo observerTwo3 = new ObserverTwo();

        //2.初始化一个被观察者
        MyObservable observable = new MyObservable();

        //3.注册一系列观察者
        observable.addObserver(observerTwo);
        observable.addObserver(observerTwo0);
        observable.addObserver(observerTwo1);
        observable.addObserver(observerTwo2);
        observable.addObserver(observerTwo3);

        //4.改变被观察者的状态
        observable.setState(9);

        System.out.println(observerTwo.getState());
        System.out.println(observerTwo0.getState());
        System.out.println(observerTwo1.getState());
        System.out.println(observerTwo2.getState());
        System.out.println(observerTwo3.getState());
    }

}

/**
 * 被观察者实现类
 */
@Data
class MyObservable extends Observable {

    private int state;

    public void changeState(int state) {
        this.state = state;  //改变目标对象的状态
        setChanged();  //表示目标对象的状态已经被改变
        notifyObservers(state);  //通知所有观察者，
    }

}

/**
 * 观察者实现类
 */
@Data
class ObserverTwo implements Observer {

    private int state;

    @Override
    public void update(Observable o, Object arg) {
        this.state = ((MyObservable) o).getState();
//        System.out.println(this.state);
    }
}
