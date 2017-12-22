package com.example.custom;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaojun on 2017/12/17.
 */

public class MyArrayList extends AbstractList implements List{

    public MyArrayList(int initialCapacity){

    }

    @Override public boolean add(Object o) {
        return super.add(o);
    }

    public void ensureCapacity() {

    }



    @Override public Object get(int i) {
        return null;
    }

    @Override public int size() {
        return 0;
    }
}


