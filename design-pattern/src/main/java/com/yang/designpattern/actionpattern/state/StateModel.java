package com.yang.designpattern.actionpattern.state;

/**
 * @author: Yang
 * @date: 2019/8/18 13:58
 * @description: 状态模式
 * 情景：电梯运行，电梯处于维修、正常、自动关门、自动开门、向上运行、向下运行、消防状态等不同状态时
 * 交通灯处于红灯、绿灯、黄灯时
 * 公司里流程的分级审批流转
 * 电商购物，订单处于下单、已支付、已发货、送货中、已签收等不同状态，对应不同的行为。
 * 核心：解决系统中复杂对象的状态切换，以及不同状态下对象行为的封装问题。
 * 结构：Context上下文类，负责各方交互；同时维护一个State，其对象代表着了当前的状态。
 * State抽象状态类
 * ConcresteState具体状态类，每一个具体状态类封装了对应的行为。
 * 用例：酒店房间、OA公文流转、线程对象状态流转、银行账户状态切换。
 */
public class StateModel {

    public static void main(String[] args) {
        RoomContext context = new RoomContext();
        context.setState(new FreeState());
        context.setState(new BookedState());
    }

}

/**
 * 状态总接口
 */
interface State {

    void handle();

}

/**
 * 空闲状态
 */
class FreeState implements State {

    @Override
    public void handle() {
        System.out.println("房间空闲，没人住！");
    }

}

/**
 * 入住状态
 */
class CheckedInState implements State {

    @Override
    public void handle() {
        System.out.println("房间已入住，请勿打扰！");
    }

}

/**
 * 预定状态
 */
class BookedState implements State {

    @Override
    public void handle() {
        System.out.println("房间已预定，不可订！");
    }

}

/**
 * 上下文类，加入这是银行系统，这个上下文就是银行账户，根据金额，切换不同的状态。
 */
class RoomContext {

    /**
     * 当前状态
     */
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        System.out.println("状态被修改！");
        this.state = state;
        state.handle();
    }
}
