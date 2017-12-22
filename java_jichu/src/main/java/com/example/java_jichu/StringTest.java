package com.example.java_jichu;

/**
 * Created by wuxiaojun on 2017/12/22.
 */

public class StringTest {

    public static void main(String[] args){
        Integer a = 1456;

        String aStr = a.toString();
        int length = aStr.length();
        String result = aStr.substring(length-3);
        System.out.println(result);

    }

    public String convert(int value){
        String valueStr = String.valueOf(value);
        int length = valueStr.length();
        if(length > 3){
            return valueStr.substring(length-3);
        }
        return null;
    }

}
