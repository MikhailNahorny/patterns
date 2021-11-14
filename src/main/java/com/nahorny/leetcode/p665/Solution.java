/**
 *Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element. *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * https://leetcode.com/problems/non-decreasing-array/
 */
package com.nahorny.leetcode.p665;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 3};
        int[] nums1 = {3, 4, 2, 3};
        int[] nums2 = {5, 7, 1, 8};
        int[] nums3 = {4, 2, 3};
        int[] nums4 = {1, 2, 4, 5, 3};

        System.out.println(checkPossibility(nums));
        System.out.println(checkPossibility(nums1));
        System.out.println(checkPossibility(nums2));
        System.out.println(checkPossibility(nums3));
        System.out.println(checkPossibility(nums4));
    }

    public static boolean checkPossibility(int[] nums) {
        if ((nums.length == 1) || ((nums.length == 2 & nums[0] <= nums[1]))) return true;
        int step = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (step != -1) {
                    return false;
                } else {
                    step = i;
                }
            }
        }
        if (step == -1 | step == 0 | step == nums.length - 2) {
            return true;
        }
        return (nums[step - 1] <= nums[step + 1]) | ((step + 2 < nums.length) && (nums[step] <= nums[step + 2]));

    }//method
}//class
