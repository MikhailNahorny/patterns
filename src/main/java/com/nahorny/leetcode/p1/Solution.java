/*
  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  https://leetcode.com/problems/two-sum/
 */
package com.nahorny.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        //1. iterate array in the loop
        for (int i = 0; i < nums.length; i++) {
            //3. if the map contains key equal to current element of array it means that
            // value referenced with such key was putted to map before and there are 2 elements we have to find
            // put index into result array and break the loop
            if (map.containsKey(nums[i])) {
                result[1] = i;
                break; //only one valid answer exists
            } else {
                //2. put into the map where key = target - value, and the value is current element of array
                map.put(target - nums[i], nums[i]);
            }
        }
        //4. now find other index. it's known that other index less than already found
        for (int i = 0; i < result[1]; i++) {
            if (nums[i] == target - nums[result[1]]) {
                result[0] = i;
            }
        }
        return result;
    }


}
