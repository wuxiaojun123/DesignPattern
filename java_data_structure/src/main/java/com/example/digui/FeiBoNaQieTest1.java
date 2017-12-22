package com.example.digui;

/**
 * 斐波那契数列，又称黄金分割
 * 0，1，1，2，3，5，8，
 * 也就是f(n) = f(n-1)+f(n-2);
 * 并且f(0)=0,f(1)=1
 * Created by wuxiaojun on 2017/12/17.
 */

public class FeiBoNaQieTest1 {

    public static void main(String[] args) {
        /***
         * f(3) = f(3-1)+f(3-2)
         *      = f(2) + f(1)
         *      = f(2-1)+f(2-2)+f(1)
         *      = f(1)+f(0)+f(1)
         */
        int result = getFieBoNaQie(3);
//        System.out.println(result);

        int tuziResult = tuZi(5);
        System.out.println("总数"+tuziResult);
    }

    public static int getFieBoNaQie(int n) {
        if (n < 0) {
            System.out.println(-1);
            return -1;
        } else if (n == 0) {
            System.out.println(0);
            return 0;
        } else if (n == 1 || n == 2) {
            System.out.println("第"+n+"个月，兔子总量"+1);
            return 1;
        } else {
            int a = getFieBoNaQie(n - 1) ;
            int b = getFieBoNaQie(n - 2);
            System.out.println("第"+(n-1)+"个月，兔子总量"+(a));
            System.out.println("第"+(n-2)+"个月，兔子总量"+(b));
            return a+b;
        }
    }

    /***
     * 兔子问题，有一对兔子，出生后第三个月起每个月生一对兔子
     * 小兔子出生后第三个月起每个月又生一对兔子
     * 假设兔子都不死，问每个月兔子的总量是多少？
     */
    public static int tuZi(int n){
        if(n == 0){
            return 0;
        }else if(n == 1 || n == 2){
            return 1;
        }else{
            return tuZi(n-1)+tuZi(n-2);
        }
    }

}
