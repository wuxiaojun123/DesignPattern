package com.example.sort;

/**
 * 直接插入排序
 * 思想是：9和3比较，3比9小，则为3,9，然后再和10比较，9比10小，则为3，9，10
 * Created by wuxiaojun on 2017/12/14.
 */

public class InsertSort {

    public static final int[] ARRAYS_SORT = {9, 3, 10, 2, 5, 1, 99, 88, 11, 2, 8, 7, 0, -1, 89};

    // 比如说排到3,9,现在10要插入进来
    public static void main(String[] args) {

        for (int i = 0; i < ARRAYS_SORT.length; i++) {
            int temp = ARRAYS_SORT[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if(ARRAYS_SORT[j] > temp){ // 如果ARRAYS_SORT[j](10)>temp(2)，那么需要把
                    ARRAYS_SORT[j+1] = ARRAYS_SORT[j]; // 这里是调换位置，把大的放后面，小的放前边继续比较
                }else{
                    break;
                }
            }
            ARRAYS_SORT[j+1] = temp;
        }
        forEach(ARRAYS_SORT);
    }

    public static void forEach(int[] arrgs) {
        for (int j = 0; j < arrgs.length; j++) {
            System.out.print(arrgs[j] + "  ");
        }
        System.out.println("遍历完成");
    }

}
