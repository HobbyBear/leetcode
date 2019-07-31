package com.xch.leetcode.suanfa.p1;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            res[0] = i;
            for (int j = i + 1 ; j < nums.length ; j++){
                if (nums[j] == target - nums[i]){
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }
}