package com.nahorny.collections;

/**
 * This is an example of using stream api.
 *
 * task: to create scream of students, get list of lastnames contains more than 3 vowels
 *
 * see also https://habr.com/ru/company/luxoft/blog/270383/
 */

import com.nahorny.collections.myimplementation.objectsexamples.Student;

import java.util.List;

public class StreamAPIExample {
    public static void main(String[] args) {
        final int QUANTITY = 50;
        List<Student> students = Student.generateStudent(QUANTITY);
        students.stream()
                .peek(System.out::println)
                .sorted(Student.ByAge)
                .peek(System.out::println)
                .map(Student::getLastName)
                .map(String::toUpperCase)
                .filter(StreamAPIExample::vowelsRegEx)
                .sorted()
                .forEach(System.out::println);
    }

    private static boolean vowels(String s) {
        int counter = 3;
        String vowelStr = "AaEeIiOoUuYy";
        char[] word = s.toCharArray();
        for (char w : word) {
            if (vowelStr.indexOf(w) != -1) {
                counter --;
                if (counter == 0) return true;
            }
        }
        return false;
    }

    private static boolean vowelsRegEx(String s) {
        final String RegEx = "(.*[AaEeIiOoUuYy].*){3}";
        return s.matches(RegEx);
    }
}
