package com.example.java_designpattern.easyFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by wuxiaojun on 2018/11/9.
 */

public class Client {

    public static void main(String[] args) {

        API api = Factory.createApi(1);
        api.test1("哈哈，不用紧张，只是个测试而已");

        api = Factory.createApiByProperties();
        api.test1("使用反射和properties来对impl 2实例化");

    }

}
