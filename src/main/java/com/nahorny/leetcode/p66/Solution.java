/**
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer. *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit. *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * https://leetcode.com/problems/plus-one/
 */
package com.nahorny.leetcode.p66;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[] nums1 = {9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums1)) + " expect 4, 3, 2, 2");
    }

    public static int[] plusOne(int[] digits) {
        byte overflow = 0; //first ime I decide to use boolean, but 99+99 shows overflow value can be 2
        int index = digits.length - 1;
        digits[index] += 1;
        do {//at least one number, so at least one iteration
            digits[index] += overflow;
            overflow = 0;
            if (digits[index] > 9){
                overflow = (byte) (digits[index] / 10);
                digits[index] %=10;
            }
            index--;
        } while (overflow != 0 & index >= 0);// stop if no overflow or we got zero-index
        if (overflow != 0){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
