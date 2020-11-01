/*
 Given a 32-bit signed integer, reverse digits of an integer.
  https://leetcode.com/problems/reverse-integer/
 */

package com.nahorny.leetcode.p7;

public class Solution {
    public static void main(String[] args) {
        int[] arg = {
                123,
                -1234,
                1002,
                1147483649, //if reverse will overflow int
                -2147483648,
                2147483647,
        };

        for (int value : arg) {
            System.out.println(value + " reverse is " + reverse(value));
        }
    }

    //-2147483648 до 2147483647
    public static int reverse(int arg) {
        long reverse = 0;
        while (arg != 0) {
            int remainder = arg % 10;
            reverse = reverse * 10 + remainder;
            arg = arg / 10;
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }
}
