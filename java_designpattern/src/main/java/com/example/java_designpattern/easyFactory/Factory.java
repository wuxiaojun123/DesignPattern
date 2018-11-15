package com.example.java_designpattern.easyFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by wuxiaojun on 2018/11/9.
 */

public class Factory {

    public static API createApi(int condition) {
        API api = null;
        if (condition == 1) {
            api = new Impl();
        } else if (condition == 2) {
            api = new Impl2();
        }
        return api;
    }

    public static API createApiByProperties() {
        Properties properties = new Properties();
        // 这里获取到的是null
        InputStream inputStream = Factory.class.getResourceAsStream("f.properties");
        try {
            if (inputStream != null)
                properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        API api = null;
        try {
            api = (API) Class.forName(properties.getProperty("ImplClass")).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return api;
    }

}
