package com.example.sort;

/**
 * 二分插入法
 * 一个一个的排序，例如9, 3, 10, 2, 5, 1, 99, 88, 11, 2, 8, 7, 0, -1, 89
 * 比如说3,9,10这是已经排好的，那么2要插入进来的时候，先找到要插入的位置
 * 怎样找到要插入的位置呢？用二分查找的方法
 * 把3的下标设为left，把10的下标设为right，9的下标为mid
 * 然后2和mid进行比较，如果比mid小，则right设为mid+1为9，则
 * Created by wuxiaojun on 2017/12/14.
 */

public class BInateInsertSort {

    public static final int[] ARRAYS_SORT = {9, 3, 10, 2, 5, 1, 99, 88, 11, 2, 8, 7, 0, -1, 89};

    public static void main(String[] args){



    }

}
