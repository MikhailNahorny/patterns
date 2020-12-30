/*
The try-with-resources Statement
 */
package com.nahorny.throwable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        readFirstLineFromFileWithFinallyBlockTWR("invalid_path");
        readFirstLineFromFileWithFinallyBlock("invalid_path");
    }

    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }

    static String readFirstLineFromFileWithFinallyBlockTWR(String path) throws IOException {
        //try-with-resources. resource must implements [auto]closeable
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (FileNotFoundException s) {
            System.out.println("FileNotFoundException was caught");
            return "";
        } finally {
            System.out.println("ответ на вопрос, можно ли finally прикрутить к try-with-resources");
        }
    }
}
