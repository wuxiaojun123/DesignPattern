package com.example.java_designpattern_test.factoryMethod.demo2;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public abstract class AudiFactory {

    public abstract <A extends AudiCar> A createAudiCar(Class<A> clz);

}
