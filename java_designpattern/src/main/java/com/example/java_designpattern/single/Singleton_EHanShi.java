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
 * 提问：类是什么时候装载的？
 * https://juejin.im/post/5d062ccc518825122925bc4b
 *
 * 类加载的步骤分为：加载--》验证--》准备--》解析--》初始化--》使用--》卸载
 * 静态变量实在初始化这一步执行的
 *
 */
class Singletom {

    private static final Singletom mInstance = new Singletom();

    private Singletom(){}


    public static Singletom getInstance() {
        return mInstance;
    }

}