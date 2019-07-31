package com.xch.leetcode.suanfa.p279;

import java.util.Arrays;

class Solution {

    private int[] arr;

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }

    public int numSquares(int n) {
        arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return helper(n);
    }

    /**
     * 求值为num时的最小平方个数
     *
     * @param num
     */
    private int helper(int num) {
        if (num == 0) {
            return 0;
        }
        if (arr[num] != -1) {
            return arr[num];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= num; i++) {
            min = Math.min(min, helper(num - i * i) + 1);
        }
        arr[num] = min;
        return min;
    }
}