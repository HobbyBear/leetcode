package com.xch.leetcode.suanfa.p75;

class Solution {
    public void sortColors(int[] nums) {
        int head = 0;
        int redTail = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redTail++;
                int num = nums[i];
                nums[i] = nums[head];
                nums[head] = num;
                head++;
            }
        }
        head = redTail + 1;
        for (int i = head; i < nums.length ; i++ ){
            if (nums[i] == 1){
                int num = nums[i];
                nums[i] = nums[head];
                nums[head] = num;
                head++;
            }
        }
    }
}