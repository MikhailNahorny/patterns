/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number. *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
package com.nahorny.leetcode.p167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1}; //-1 means "not found"
        int head = 0, tail = numbers.length - 1;
        //look for sum in the loop
        while (head < tail) {
            //if loop was stopped by condition it means no "no such elements which sum equal to given number"
            // otherwise  variables "head" and "tail" contains indexes is a result
            if (numbers[head] + numbers[tail] == target) {
                result[0] = head + 1;
                result[1] = tail + 1;
                break;
            } else if (numbers[head] + numbers[tail] < target) {
                //shift the window of searching
                head++;
            } else {
                tail--;
            }
        }
        return result;
    }
}
