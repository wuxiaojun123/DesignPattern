package com.example.digui;

/**
 * 计算N！的结果，通过递归和迭代的方式实现
 * Created by wuxiaojun on 2017/12/17.
 */

public class JieCentTest1 {

    public static void main(String[] args) {
        int result = diguiFactory(4);
        System.out.println("结果是:" + result);
        int result2 = xunHuanFactory(4);
        System.out.println("结果是:"+result2);
    }

    /***
     * 递归的思想是，自己调用自己，为了简化问题，需要执行代码n-1次
     * 缺点是：加大了内存消耗
     * @param n
     * @return
     */
    public static int diguiFactory(int n) {
        if (n == 0) {
            throw new IllegalArgumentException();
        } else if (n <= 1) {
            return 1;
        } else {
            return n * diguiFactory(n - 1);
        }
    }

    /***
     * 迭代是使用for循环，内存使用的少
     * @param n
     * @return
     */
    public static int xunHuanFactory(int n) {
        int product = n;
        if (n == 0) {
            throw new IllegalArgumentException();
        } else if (n <= 1) {
            return 1;
        } else {
            for(int i=(product-1);i >= 1;i--){
                product = product*i;
            }
        }
        return product;
    }

}
