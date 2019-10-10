package com.example.java_designpattern.single;

public class Singleton_EHanShi {

    public static void main(String[] args) {

    }

}

/***
 * 这种单例模式叫做饿汉式
 *
 * 饿汉式是在类加载的时候进行实例化的，所以就不存在线程安全问题
 *
 * 缺点是：不管有没有用到这个对象，都会实例化出来
 * 优点是：？
 *
 * 疑问：类加载的时候，什么时候类加载？
 */
class Singletom {

    private static final Singletom mInstance = new Singletom();

    private Singletom(){}


    public static Singletom getInstance() {
        return mInstance;
    }

}