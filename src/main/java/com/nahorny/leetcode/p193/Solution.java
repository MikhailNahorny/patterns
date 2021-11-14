package com.nahorny.leetcode.p193;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

    }

    public static void phoneValidator() {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            final String phoneReEx = "^(([(][0-9]{3}[)] )|([0-9]{3}[\\-]))[0-9]{3}[\\-][0-9]{4}";
            String line = br.readLine();
            if (line.matches(phoneReEx)) System.out.println(line);
        } catch (FileNotFoundException s) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}

