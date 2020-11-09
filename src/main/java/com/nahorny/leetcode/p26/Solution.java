/*
  Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length. *
  Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
  https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
package com.nahorny.leetcode.p26;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 2, 3, 4, 4, 5, 6};
        System.out.println(Arrays.toString(nums));

        int len = removeDuplicates(nums);

        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println("\b\b]");
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return ++index;
    }

}
