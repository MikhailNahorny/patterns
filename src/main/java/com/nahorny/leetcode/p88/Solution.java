/*
  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. *
  Note: The number of elements initialized in nums1 and nums2 are m and n respectively.
  You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
  <p>
  https://leetcode.com/problems/merge-sorted-array/
 */
package com.nahorny.leetcode.p88;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 6, 8, 9, 10, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {0, 2, 3, 5, 6, 7, 11};
        merge(nums1, 7, nums2, 7);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //merge nums2 into nums1[indexRes]
        //last positions indexes:
        int indexRes = m + n - 1; //result into nums1
        int index1 = m - 1; //given data in nums1
        int index2 = n - 1; //given data in nums2

        while (index1 >= 0 && index2 >= 0) {
            nums1[indexRes--] = (nums1[index1] >= nums2[index2]) ? nums1[index1--] : nums2[index2--];
        }
        /*
        [9, 9, 9, 0, 0, 0]
        [1, 2, 3] - if index1 == 0 AND index2 != 0, we have to all elements of num1[0 to index2] into num1
        or
        [1, 2, 3, 0, 0, 0]
        [9, 9, 9] - if index2 == 0 that's it
         */
        while (index2 >= 0) {
            nums1[indexRes--] = nums2[index2--];
        }

    }
}
