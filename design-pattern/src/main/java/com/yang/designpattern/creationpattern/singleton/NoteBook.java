package com.yang.designpattern.creationpattern.singleton;

/**
 * @author: Yang
 * @date: 2019/8/18 23:45
 * @description:
 * 用例：
 *  *      OS的任务管理器，多次打开都只有一个。
 *  *      OS的回收站。
 *  *      配置文件读取器。
 *  *      网站全局的计数器。
 *  *      系统的日志记录器，由于记录日志文件往往只能被一个程序打开和操作。
 *  *      数据库连接池对象。
 *  *      OS的文件系统。
 *  *      SpringIOC容器默认初始化的bean也是单例的。
 *  *      servlet是单例的。
 *  *      Spring-MCVC和Strust1中的控制器都是单例的。
 *  * 优点：限制了一个类在整个进程中只有一个对象实例，减少了系统资源开销，所以当一个实例对象的产生需要较多资源时，
 *  * 所以当一个对象的实例化需要加载配置文件、产生其他依赖对象时，可以在启动阶段直接产生一个单例对象，然后永久驻留内存供后续使用。
 *  * 单例模式可以在系统设置全局的访问点，优化共享资源的访问，例如可以设计一个单例对象，负责所有数据表的映射处理。
 *  *
 *  * 懒汉式：非线程安全，调用效率低，但支持延迟加载。
 *  * 饿汉式：线程安全，调用效率高，但不支持延迟加载。
 *  * 双检锁：部分jvm非线程安全，调用效率低，支持延迟加载，但不建议使用。
 *  * 静态内部类：线程安全，调用效率高，支持延迟加载。
 *  * 枚举式：线程安全，调用效率高，但不支持延迟加载。
 *
 *  要点：线程安全、延迟加载、高效调用。
 *  注意：即使私有化构造器，也不是绝对安全的，不能严格保证单实例，不可避免反射和序列化攻击，只有枚举式式绝对安全的。
 *
 *  调用效率对比：饿汉式(22ms) > 静态内部类式(28) > 枚举式(32ms) > 双检锁式(65ms) > 懒汉式(636ms)
 *
 */
public class NoteBook {
}
