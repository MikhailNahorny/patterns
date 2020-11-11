package com.nahorny.leetcode.p27;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 2, 3, 4, 4, 5, 6};
        System.out.println(Arrays.toString(nums));

        int len = removeElement(nums, 1);

        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println("\b\b]");
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
