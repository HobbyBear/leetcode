package com.xch.leetcode.search;

/**
 * @author: xch
 * @create: 2019-07-30 09:15
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(search(arr,5));
    }

    /**
     * 查找num,如果没找到返回-1
     *
     * @param arr
     * @param num
     * @return
     */
    public static int search(int[] arr, int num) {
        return searchHelper(arr, num, 0, arr.length - 1);
    }

    //在[left,right]中寻找值num的
    private static int searchHelper(int[] arr, int num, int left, int right) {
        if (left > right){
            return  -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == num){
            return mid;
        }else if (arr[mid] >num){
            return searchHelper(arr, num, left, mid-1);
        }else {
            return searchHelper(arr, num, mid+1, right);
        }
    }
}
