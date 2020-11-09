/*
  Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
  https://leetcode.com/problems/merge-two-sorted-lists/
 */
package com.nahorny.leetcode.p21;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        //initialisation of lists
        ListNode l1 = initList(10);
        ListNode l2 = initList(5);
        ListNode result;
        print(l1);
        print(l2);

        result = mergeTwoLists(l1, l2);
        print(result);

    }//main

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2; //in a particular case, this makes the method faster
        if (l2 == null) return l1; //here the condition "Example 2" is implemented
        ListNode current = new ListNode();
        ListNode result = current;
        while (l1 != null & l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) current.next = l2;
        if (l2 == null) current.next = l1;
        return result.next;
    }

    //previous solution
    public static ListNode mergeTwoLists2(final ListNode l1, final ListNode l2) {
        if (l1 == null) return l2; //in a particular case, this makes the method faster
        if (l2 == null) return l1; //here the condition "Example 2" is implemented
        ListNode result = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode curR = null;
        while (cur1 != null | cur2 != null) {
            //this statement will be meet if lists has different lengths
            if (cur2 == null & cur1 != null) {
                (getLast(curR)).next = new ListNode(cur1.val);
                cur1 = cur1.next;
                continue;
            }
            //this statement will be meet if lists has different lengths
            if (cur1 == null) {
                (getLast(curR)).next = new ListNode(cur2.val);
                cur2 = cur2.next;
                continue;
            }

            if (cur1.val <= cur2.val) {
                if (curR == null) {
                    curR = new ListNode(cur1.val);
                } else {
                    (getLast(curR)).next = new ListNode(cur1.val);
                }
                cur1 = cur1.next;
            } else {
                if (curR == null) {
                    curR = new ListNode(cur2.val);
                } else {
                    (getLast(curR)).next = new ListNode(cur2.val);
                }
                cur2 = cur2.next;
            }
            if (result == null) result = curR;

        }
        return result;
    }

    //helpers

    static ListNode getLast(final ListNode head) {
        if (head == null) return head;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public static void print(final ListNode arg) {
        ListNode current = arg;//argument is a reference type. to prevent mutation of argument
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.print("\b\b]");
        System.out.println();
    }

    public static ListNode initList(int size) {
        if (size < 0 || size > 50) throw new IllegalArgumentException("size must be between 0 and 50");
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = (int) (Math.random() * 100 * Math.sin(i));
        }
        Arrays.sort(values);
        ListNode inited = null;
        for (int value : values) {
            if (inited == null) {
                inited = new ListNode(value);
            } else {
                (getLast(inited)).next = new ListNode(value);
            }
        }
        return inited;
    }

}//Solution

