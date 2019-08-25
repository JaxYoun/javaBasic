package com.yang.designpattern.creationpattern.factory;

/**
 * @author: Yang
 * @date: 2019/8/25 18:28
 * @description: 工厂方法模式（其进步之处在于当新增产品类时，可以避免对已有代码的修改，但同时类的数量增多了）。
 */
public class FactoryMethodModel {
    public static void main(String[] args) {
        new DogFactory().createPet().shout();
        new CatFactory().createPet().shout();

        //当需要新增宠物类型时，不必修改已有代码
        new PigFactory().createPet().shout();
    }
}

/**
 * 宠物工厂接口
 */
interface PetFactory {
    Pet createPet();
}

/**
 * 宠物工厂实现类-狗工厂
 */
class DogFactory implements PetFactory {
    @Override
    public Pet createPet() {
        return new Dog();
    }
}

/**
 * 宠物工厂实现类-猫工厂
 */
class CatFactory implements PetFactory {
    @Override
    public Pet createPet() {
        return new Cat();
    }
}

/**
 * 宠物产品接口
 */
interface Pet {
    void shout();
}

/**
 * 宠物产品实现类-狗
 */
class Dog implements Pet {
    @Override
    public void shout() {
        System.out.println("我是狗子");
    }
}

/**
 * 宠物产品实现类-猫
 */
class Cat implements Pet {
    @Override
    public void shout() {
        System.out.println("我是猫猫");
    }
}

//------------------------------几周以后，需要新增宠物猪类型-------------------------------

/**
 * 新增的宠物产品实现类-猪
 */
class Pig implements Pet {
    @Override
    public void shout() {
        System.out.println("我是猪猪");
    }
}

/**
 * 新增的宠物工厂实现类-猪工厂
 */
class PigFactory implements PetFactory {
    @Override
    public Pet createPet() {
        return new Pig();
    }
}




