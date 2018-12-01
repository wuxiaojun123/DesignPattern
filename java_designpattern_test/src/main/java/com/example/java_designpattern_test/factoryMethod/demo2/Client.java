package com.example.java_designpattern_test.factoryMethod.demo2;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class Client {

    public static void main(String[] args) {

        AudiFactory audiFactory = new AudiCarFactory();
        AudiCar audiCar = audiFactory.createAudiCar(AudiQ3Car.class);
        audiCar.drive();
        audiCar.selfNavigation();

        audiCar = audiFactory.createAudiCar(AudiQ5Car.class);
        audiCar.drive();
        audiCar.selfNavigation();

        audiCar = audiFactory.createAudiCar(AudiQ7Car.class);
        audiCar.drive();
        audiCar.selfNavigation();

    }

}
