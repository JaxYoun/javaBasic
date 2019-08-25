package com.yang.designpattern.creationpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Yang
 * @date: 2019/8/25 19:14
 * @description:建造者模式 构建复杂对象时，一般需要创建部件，同时还需要对部件按规则进行组装，此时就可以用建造者模式。
 * 达到了创建和装配部件算法的解耦，进而在两个过程都可以自由组合，提供更好的扩展性和复用性。
 * 用例：StringBuilder的append()方法，prepareStatement，JDOM的SaxBuilder和DomBuilder。
 *
 */
public class BuilderModel {

    public static void main(String[] args) {
        Airship airship = new MyAirshipDirector(new MyAirshipBuilder()).directAirship();
        System.out.println(airship.getEngine().getName());
    }

}

/**
 * 飞船建造器接口
 */
interface AirshipBuilder {
    Engine createEngine();
    Site createSite();
    Tyre createTyre();
}

class MyAirshipBuilder implements AirshipBuilder {
    @Override
    public Engine createEngine() {
        return new Engine("yang-engine");
    }

    @Override
    public Site createSite() {
        return new Site("yang-site");
    }

    @Override
    public Tyre createTyre() {
        return new Tyre("yang-tyre");
    }
}

/**
 * 飞船组装器接口
 */
interface AirshipDirector {
    Airship directAirship();
}

@AllArgsConstructor
class MyAirshipDirector implements AirshipDirector {
    private AirshipBuilder airshipBuilder;

    @Override
    public Airship directAirship() {
        //1.创建组件
        Engine engine = this.airshipBuilder.createEngine();
        Site site = this.airshipBuilder.createSite();
        Tyre tyre = this.airshipBuilder.createTyre();
        //2.组装成品
        return new Airship(engine, site, tyre);
    }
}

/**
 * 飞船类
 */
@Data
@AllArgsConstructor
class Airship {
    private Engine engine;
    private Site site;
    private Tyre tyre;
}

@Data
@AllArgsConstructor
class Engine {
    private String name;
}

@Data
@AllArgsConstructor
class Site {
    private String name;
}

@Data
@AllArgsConstructor
class Tyre {
    private String name;
}
