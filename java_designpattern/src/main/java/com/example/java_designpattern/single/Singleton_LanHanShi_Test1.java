package com.example.java_designpattern.single;

public class Singleton_LanHanShi_Test1 {


    public static void main(String[] args) {


    }

}

/***
 * 这种方式会有线程安全问题，遇到多个线程的时候，不能保证类的只有一个实例
 */
class Singletom1 {

    private static Singletom1 instance;

    private Singletom1(){
    }

    public static Singletom1 getInstance() {
        if(instance == null) {
            instance = new Singletom1();
        }
        return instance;
    }

}

/***
 * 这种方式线程安全了，但是每次获取实例都要排队等待，所以会造成效率低，因为每次都要排队
 * 疑问：synchronized效率为什么会低？
 */
class Singletom2 {

    private static Singletom2 instance;

    private Singletom2(){}


    public static synchronized Singletom2 getInstance() {
        if(instance == null) {
            instance = new Singletom2();
        }
        return instance;
    }

}

/***
 * 这种方式最完美
 *
 * 疑问：1 为什么要双重校验？
 *      答：第一个判断null是为了解决以后不用每次都进入到同步代码块中，解决效率低的问题
 *         第二个判断null是为了解决首次如果多个线程都到达synchronized同步代码块这里，当第一个线程执行完实例化操作之后，第二个线程进入同步代码块
 *         这个时候是已经存在instance对象了，不需要再进行new的操作了。
 *
 * 2 为什么还要使用volatile关键字
 * 答：是为了将线程工作内存中的数据刷新到主内存中
 */
class Singletom3 {

    private static volatile Singletom3 instance;

    private Singletom3(){}

    public static Singletom3 getInstance() {
        if(instance == null) {
            synchronized(Singletom3.class) {
                if(instance == null) {
                    instance = new Singletom3();
                }
            }
        }
        return instance;
    }

}

















