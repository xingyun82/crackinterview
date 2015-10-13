package corejava;

import java.io.Serializable;

/**
 * Created by xingyun on 15/9/6.
 */

// Effective java 推荐 枚举 和 饿汉 方式
// 枚举
enum SingletonEnum {

    INSTANCE;

    public void doSth() {
        System.out.println("singleton");
    }
}


// 饿汉
class SingletonInit {

    private static SingletonInit inst = new SingletonInit();

    private SingletonInit() {}

    public static SingletonInit getInstance() {
        return inst;
    }
}


// 懒汉
class SingletonLazy {

    private static SingletonLazy inst = null;

    private SingletonLazy() {

    }

    public static synchronized SingletonLazy getInstance() {
        if(inst == null) {
            inst = new SingletonLazy();
        }
        return inst;
    }
}

// internal static class
class SingletonInternalClass {

    private static class SingletonHodler {
        private static SingletonInternalClass inst = new SingletonInternalClass();
    }

    private SingletonInternalClass(){}

    public static SingletonInternalClass getInstance() {
        return SingletonHodler.inst;
    }
}

// double check
class SingletonDoubleCheck implements Serializable {

    private static SingletonDoubleCheck inst = null;

    private SingletonDoubleCheck(){};

    public static SingletonDoubleCheck getInstance() {
        if(inst == null) {
            synchronized (SingletonDoubleCheck.class) {
                if(inst == null) {
                    inst = new SingletonDoubleCheck();
                }
            }
        }
        return inst;
    }

    // 对于单例可以序列化/反序列化的时候，需要注意反序列化时要返回单例
    public Object readResolve() {
        return inst;
    }

}

public class SingletonTest {

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.doSth();
    }
}


