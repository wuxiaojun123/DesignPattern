package com.example.java_designpattern_test.factoryMethod.demo1;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class ConcreateFactory extends Factory {


    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        Product p = null;
        try {
            p = (Product) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) p;
    }


}
