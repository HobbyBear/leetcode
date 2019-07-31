package com.xch.leetcode.suanfa.p283;

class Solution {
    //O(n)
    public void moveZeroes(int[] nums) {
        int head = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0 ){
                int num = nums[i];
                nums[i] = nums[head];
                nums[head] = num;
                head++;
            }
        }
    }
}