/*
  Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward. *
  Follow up: Could you solve it without converting the integer to a string?
  https://leetcode.com/problems/palindrome-number/
 */
package com.nahorny.leetcode.p9;

public class Solution {
    public static void main(String[] args) {
        int[] arg = {
                123454321,
                -123454321,
                12345432,
                1001,
                10601,
                121
        };
        for (int value : arg) {
            System.out.println(value + " is " + (isPalindrome(value) ? "palindrome" : "not palindrome"));
        }
    }

    public static boolean isPalindrome(int arg) {
        if (arg < 0) return false;
        int forward = arg;
        int back = 0;
        while (arg != 0) {
            int remainder = arg % 10;
            back = back * 10 + remainder;
            arg = arg / 10;
        }
        return forward == back;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        char[] arg = ("" + x).toCharArray();
        for (int i = 0; i < arg.length/2; i++) {
            if(arg[i] != arg[arg.length - 1 - i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        String arg = "" + x;
        for (int i = 0; i < arg.length()/2; i++) {
            if (arg.charAt(i) != arg.charAt(arg.length() - 1 - i))return false;
        }
        return true;
    }
}
