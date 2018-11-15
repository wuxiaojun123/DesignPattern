package com.example.java_jichu.yunsuanfu;

/**
 * ++i和i++的区别
 * 前置加加其实等价于i+=1;也就是i=i+1;
 * 后置加加其实是先赋值给了一个临时变量，然后再把i进行+1，然后使用临时变量进行计算
 * i++等价于
 * int temp = i;
 * i = i+1;
 * temp = temp+1;
 * Created by wuxiaojun on 2017/12/21.
 */

public class Test1 {

    public static void main(String[] args) {
        int i = 1;
        i++;
        System.out.println(i);
        int j = 1;
        ++j;
        System.out.println(j);

        int a = 10;
        int b = 20;
        int c = a++ + b;
        System.out.println(c);

        int d = 1;
        int f = ++d + d++; // d=3,f=4
        System.out.println("d=" + d + "f=" + f);
    }

}
