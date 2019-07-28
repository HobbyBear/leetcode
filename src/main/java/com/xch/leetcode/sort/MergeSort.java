package com.xch.leetcode.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 思想：将一个大问题转变为小问题，将对n个数的排序转换为对m（m<n)个数的排序，最后将排序好的数字进行合并
 * @author: xch
 * @create: 2019-07-26 11:47
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int[] temp = new int[arr.length];
        sortHelper(arr, left, right, temp);
    }

    //对arr[left,right]进行归并排序
    private static void sortHelper(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortHelper(arr, left, mid, temp);
            sortHelper(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }


    //对[left,mid],和[mid+1,right]进行合并
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int t = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (arr[l] >= arr[r]) {
                temp[t++] = arr[r++];
            } else {
                temp[t++] = arr[l++];
            }
        }
        while (l > mid && r <= right) {
            temp[t++] = arr[r++];
        }
        while (r > right && l <= mid) {
            temp[t++] = arr[l++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
