package com.example.digui;

/**
 * 进制转换
 * Created by wuxiaojun on 2017/12/17.
 */

public class JinZhiConvert {

    public static void main(String[] args) {
        /***
         * 计算机中都是使用二进制值，所以都要将十进制转化为二进制
         * 十进制转为二进制思路,例如将n转为二进制数
         * 1 二进制的最后一位是n%2
         * 2 结束条件是商为1的时候，结束
         */
        writeBinary(12);
    }

    /***
     * 思路：什么时候结束递归？当商为1的时候结束
     * 而且得从商为1的时候开始输出,
     * 最后一个元素需要取模
     * @param n
     */
    public static void writeBinary(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n <= 1) {
            System.out.print(n / 2);
        } else {
            writeBinary(n / 2);
            System.out.print(n % 2);
        }
    }

}
