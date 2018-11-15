package com.wxj.datastructure.sort;

/**
 * 插入排序
 * Created by wuxiaojun on 2017/12/14.
 */

public class InsertSort {

    public static final int[] ARRAYS_SORT = {9, 3, 10, 2, 5, 1, 99, 88, 11, 2, 8, 7, 0, -1, 89};

    // 比如说排到3,9,现在10要插入进来
    public static void main(String[] args) {

        for (int i = 0; i < ARRAYS_SORT.length; i++) { // i=2
            int temp = ARRAYS_SORT[i]; // 10
            for (int j = i - 1; j >= 0; j--) { // j=1
                if (temp > ARRAYS_SORT[j]) { // ARRAYS_SORT[j]=9,temp=10,10>9，那么应该
                    ARRAYS_SORT[j + 1] = temp;
                    break;
                } else { // ARRAYS_SORT[j]=10,temp=2，
                    ARRAYS_SORT[j + 1] = ARRAYS_SORT[j];
                }
            }
        }
        forEach(ARRAYS_SORT);
    }

    public static void forEach(int[] arrgs) {
        for (int j = 0; j < arrgs.length; j++) {
            System.out.print(arrgs[j]);
        }
        System.out.println("遍历完成");
    }

}
