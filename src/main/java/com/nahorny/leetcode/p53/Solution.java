/*
  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. *
  Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
  https://leetcode.com/problems/maximum-subarray/
 */
package com.nahorny.leetcode.p53;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums) + " expect 6");
    }

    public static int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = curr;
        for (int i = 1; i < nums.length; i++) {
            curr = (curr > 0) ? curr + nums[i] : nums[i];
            max = (curr > max) ? curr : max;
        }
        return max;
    }
}
