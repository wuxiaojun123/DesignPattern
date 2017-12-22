package com.example.sort;

/**
 * 堆排序
 * Created by wuxiaojun on 2017/12/15.
 */

public class HeadSort {

    public static void main(String[] args) {
        int[] arrays = {99, 88, 101, 2, 9, 6, 22, 0, 123, 987, 6, 8, 19};
        headSort(arrays);
        forEach(arrays);
    }

    public static void headSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        //创建大堆
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            exchangeElements(a,0,i);
            maxHeap(a,i,0);
        }
    }

    public static void buildMaxHeap(int[] a) {
        // 只需要遍历一半，因为拿到一半
        int half = (a.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(a, a.length, i);
        }
    }

    public static void maxHeap(int[] a, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < length && a[left] > a[i]) {
            largest = left;
        }
        if (right < length && a[right] > a[largest]) {
            largest = right;
        }
        if (i != largest) {
            // 进行数据交换
            exchangeElements(a, i, largest);
            // 再进行大堆的构造
            maxHeap(a, length, largest);
        }
    }

    private static void exchangeElements(int[] a, int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }

    public static void forEach(int[] arrgs) {
        for (int j = 0; j < arrgs.length; j++) {
            System.out.print(arrgs[j] + "  ");
        }
        System.out.println("遍历完成");
    }

}
