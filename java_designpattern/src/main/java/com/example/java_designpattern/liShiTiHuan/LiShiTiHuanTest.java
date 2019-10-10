package com.example.java_designpattern.liShiTiHuan;

public class LiShiTiHuanTest {


    public static void main(String[] args){



    }

}


class A{

    public int func1(int num1,int num2){
        return num1 - num2;
    }

}

class B extends A {

    public int func1(int a,int b){
        return a+b;
    }

    public int func2(int a,int b){
        return func1(a,b)+9;
    }

}

