package com.example.java_designpattern_test.factoryMethod.demo2;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class AudiCarFactory extends AudiFactory {


    @Override
    public <A extends AudiCar> A createAudiCar(Class<A> clz) {
        AudiCar audiCar = null;
        try {
            audiCar = (AudiCar) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (A) audiCar;
    }


}
