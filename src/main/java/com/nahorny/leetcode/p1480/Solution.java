/*
  Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]). *
  Return the running sum of nums.
  https://leetcode.com/problems/running-sum-of-1d-array/
 */
package com.nahorny.leetcode.p1480;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int[] nums1 = {1,2,3,4};

        arrPrint(nums1);
        arrPrint(runningSum(nums1));
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void arrPrint(int[] nums){
        System.out.print("[");
        for(int n : nums) System.out.print(n + ", ");
        System.out.print("\b\b]\n");
    }
}
