package com.xch.leetcode.suanfa.p167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length -1;
        while (  l < r) {
            if ((numbers[l] + numbers[r]) > target) {
                r--;
            } else if ((numbers[l] + numbers[r]) < target) {
                l++;
            } else {
                res[0] = l;
                res[1] = r;
                return res;
            }
        }
        return null;
    }
}