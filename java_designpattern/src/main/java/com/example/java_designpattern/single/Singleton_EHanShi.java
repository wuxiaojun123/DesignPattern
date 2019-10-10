package com.example.java_designpattern.single;

public class Singleton_EHanShi {

    public static void main(String[] args) {

    }

}

/***
 * 这种单例模式叫做饿汉式
 *
 * 饿汉式是在类装载的时候进行实例化的，所以就不存在线程安全问题
 * 我们应该还记得static的作用
 * static：
 *  1.多个实例的static变量会共享同一块内存区域
 *  2.静态变量在类装载的时候就会进行初始化
 *
 * 缺点是：不管有没有用到这个对象，都会实例化出来
 *
 * 疑问：类加载的时候，什么时候类装载？
 *
 */
class Singletom {

    private static final Singletom mInstance = new Singletom();

    private Singletom(){}


    public static Singletom getInstance() {
        return mInstance;
    }

}