package com.yang.designpattern.actionpattern.templatemethod;

/**
 * @author: Yang
 * @date: 2019/8/18 13:03
 * @description: 模板方法模式【很常用】
 * 定义：它约定了一个操作中的方法骨架，将某些步骤延迟到子类中实现，这样，新的子类就可以在不改变算法结构的前提下，重新定义算法的某些特定步骤。
 * 核心：处理某个流程的代码已经大体具备，但其中某些环节的代码还暂时不能确定，此时采用模板方法模式可以将不确定的部分转移到子类中实现，
 * 亦即将处理流程在父类中定义好，具体实现延迟到子类实现。
 * 情景：到餐厅用餐，虽然不知道具体吃什么，但是流程是固定的，都是：点餐-用餐-买单，这个流程是固定的，就可以定义为一个模板，
 * 规范好一个个方法来定义流程的处理步骤。
 * 好莱坞原则：父类相当于经纪人，子类相当于艺人，艺人只是等待经纪人的调用而不能调用经纪人。
 * 使用时机：实现一个功能时，整体流程比较固定，但某些环节可能有多种实现，此时可以将会变动的部分抽象出来，由子类去实现。
 * 常见用例：在各个框架、类库中使用非场频繁，比如：spring-data-xxx，Junit单元测试、servlet中关于doGet和doPost的方法调用、Hibernate中的模板程序。
 */
public class TemplateMethodModel {

    public static void main(String[] args) {
        //1.传统式
        BankTemplate bank = new Icbc();
        bank.process();

        //2.匿名子类式
        BankTemplate bankTemplate = new BankTemplate() {
            @Override
            void kkk() {
                System.out.println("我要存钱");
            }
        };
        bankTemplate.process();

        //3.匿名子类式
        new BankTemplate() {
            @Override
            void kkk() {
                System.out.println("中国农业银行取款");
            }
        }.process();
    }

}

abstract class BankTemplate {

    private void takeMenue() {
        System.out.println("点菜！");
    }

    /**
     * 变化部分的核心方法，由子类具体实现，称为回调方法，也叫钩子方法
     */
    abstract void kkk();

    private void chekIn() {
        System.out.println("结账！");
    }

    public final void process() {
        this.takeMenue();
        this.kkk();
        this.chekIn();
    }

}

class Icbc extends BankTemplate {

    @Override
    void kkk() {
        System.out.println("中国工商银行取钱！");
    }
}
