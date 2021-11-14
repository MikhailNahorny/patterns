/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * https://leetcode.com/problems/third-maximum-number/
 */
package com.nahorny.leetcode.p414;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, -2147483648};
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {1, -2147483648, 2};

        System.out.println(thirdMax(nums2));
    }

    public static int thirdMax(int[] arg) {
        if (arg.length == 2) return Math.max(arg[0], arg[1]);
        if (arg.length == 1) return arg[0];
        long max1, max2, max3;
        max1 = max2 = max3 = (long) Integer.MIN_VALUE - 1; //при всем желании, без применения следующего типа не обошлось
        for (int current : arg) {
            if (current >= max1) {
                if (current == max1) continue;//Note that the third maximum here means the third maximum distinct number
                max3 = max2;
                max2 = max1;
                max1 = current;
            } else if (current >= max2) {
                if (current == max2) continue;
                max3 = max2;
                max2 = current;
            } else if (current >= max3) {
                max3 = current;
            }
        }
        return (max3 >= (long) Integer.MIN_VALUE) ? (int) max3 : (int) max1;
    }
}
