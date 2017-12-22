package com.example.java_jichu.yunsuanfu;

/**
 * 重载：参数不同(类型，顺序，个数)
 *      返回值可以相同也可以不同
 *      修饰符也可以不同
 *      注意：static和private的方法不可重写，因为这两个方法总是隐式的为final
 * 重写：当子类继承了父类的时候，重写某一个方法，只有修饰符可以不同，其他都必须相同
 * Created by wuxiaojun on 2017/12/21.
 */

public class ChongZaiTest extends ChongZaiTestParent{



    @Override public int test(int a) {
        return super.test(a);
    }

    public static void main(String[] args){

    }

}
