package com.xch.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序 ,遍历的元素前面是有序的
 * O(n^2)
 * @author: xch
 * @create: 2019-07-26 09:53
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int num = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = num;
                } else {
                    break;
                }
            }
        }
    }
}
