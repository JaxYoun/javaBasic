package com.yang.designpattern.actionpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/8/17 21:59
 * @description: 命令模式
 * <p>
 * 将每一个命令封装为一个对象，使我们可以用不同的请求对客户的请求进行参数化；
 * 将一连串请求进行缓存收集、编排、排队、记录日志等中间分装然后再发给接收方，以及支持可撤销操作，
 * 当命令序列比较复杂时，避免了发起者和接收者的直接通信。
 * 也称为Action模式和Transaction模式。
 * 场景：数据库事务底层就是通过此模式实现的、Strust中action的调用过程、结合备忘录模式实现可撤销操作。
 * </p>
 */
public class CommandModel {

    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Reciver());
        Invoker invoker = new Invoker(command);
        invoker.call();
    }

}

/**
 * 命令接口
 */
interface Command {

    /**
     * 执行
     */
    void execute();

}

/**
 * 命令实现类
 */
class ConcreteCommand implements Command {

    private Reciver reciver;

    public ConcreteCommand(Reciver reciver) {
        super();
        this.reciver = reciver;
    }

    @Override
    public void execute() {
        reciver.action();
    }
}

/**
 * 命令接收者
 */
class Reciver {

    public void action() {
        System.out.println("action-------");
    }
}

/**
 * 命令发起者
 */
class Invoker {

    /**
     * 用于盛放多个命令组合
     */
    private List<Command> commandList = new ArrayList<>();

    public Invoker(Command command) {
        super();
        this.commandList.add(command);
    }

    /**
     * 业务方法，用于调用命令的方法
     */
    public void call() {
        this.commandList.forEach(Command::execute);
    }
}


