/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package com.nahorny.leetcode.p2;

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
        ListNode l1 = initList(4);
        ListNode l2 = initList(5);
        ListNode result;
        print(l1);
        print(l2);

        result = addTwoNumbers(l1, l2);
        print(result);



    }//main

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode result = current;
        int c = 0;
        int i = 0;
        while (l1 != null & l2 != null) {
            System.out.println(++i);
            c = l1.val + l2.val;
            if (c < 10) {
                current.val = c;
                c = 0;
            } else {
                current.val = c - 10;
                c = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            current.next = current;
        }
//        if (l1 == null) current.next = l2;
//        if (l2 == null) current.next = l1;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                c += l2.val;
                if (c < 10) {
                    current.val = c;
                    current.next = l2.next;
                } else {
                    current.val = c - 10;
                    c = 1;
                }
                l2 = l2.next;
                current.next = current;
            }
            if (l2 == null) {
                c += l1.val;
                if (c < 10) {
                    current.val = c;
                    current.next = l1.next;
                } else {
                    current.val = c - 10;
                    c = 1;
                }
                l1 = l1.next;
                current.next = current;
            }
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
            values[i] = (int) (Math.random() * 9 + 1);
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

