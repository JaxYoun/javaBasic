package com.yang.designpattern.creationpattern.singleton;

/**
 * @author: Yang
 * @date: 2019/8/19 22:48
 * @description: 双检锁：逻辑结构和懒汉式相似，也支持延迟加载，只是在实例化时通过双重同步来保证线程安全、提高调用效率。
 */
public class DoubleCheckLockModel {

    /**
     * 0.持有全局的对象引用，先不实例化，只有真正用的时候再初始化，它的实例化过程是非线程安全的，要考虑并发场景下的可见性
     */
    volatile private static DoubleCheckLockModel INSTANCE;

    /**
     * 1.私有化类的构造器
     */
    private DoubleCheckLockModel() {
    }

    /**
     * 2.由于实例化过程是非线程安全的，所以需要对构造过程做同步处理，同步会【降低调用效率】
     *
     * @return
     */
    public static DoubleCheckLockModel getInstance() {
        if (INSTANCE == null) {
            DoubleCheckLockModel temp;
            synchronized (DoubleCheckLockModel.class) {
                temp = INSTANCE;
                if (temp == null) {
                    synchronized (DoubleCheckLockModel.class) {
                        if (temp == null) {
                            temp = new DoubleCheckLockModel();
                        }
                    }
                }
                INSTANCE = temp;
            }
        }
        return INSTANCE;
    }

}
