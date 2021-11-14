/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
package com.nahorny.leetcode.p215;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        int k1 = 4;
        System.out.println(findKthLargest(nums, k));
        System.out.println(findKthLargest(nums1, k1));
    }

    public static int findKthLargest(int[] arr, int k) {
        Arrays.sort(arr); // n log n
        return arr[arr.length - k];
    }
}
