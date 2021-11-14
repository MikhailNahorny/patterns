/*
  Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
  https://leetcode.com/problems/pascals-triangle/
 */
package com.nahorny.leetcode.p118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> generated = generate(5);
        generated.forEach(System.out::println);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {//rows
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {//row
                //it is  j position in i row, current = [i-1][j-1] + [i-1][j]
                int current;
                if (j == 0 | j == i) current = 1;
                else {
                    List<Integer> previousRow = rows.get(i - 1);//get [i-1]-th nested list
                    current = previousRow.get(j - 1) + previousRow.get(j);//get [j-1] and [j] positions in [i-1] nested list
                }
                row.add(current);
            }//row
            rows.add(row);
        }//rows
        return rows;
    }
}
