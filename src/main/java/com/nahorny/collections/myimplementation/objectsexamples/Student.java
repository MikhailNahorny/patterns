package com.nahorny.collections.myimplementation.objectsexamples;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int lastID;
    private int id;
    private String lastName;
    private int age;

    public Student(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public Student(String lastName, int age) {
        if (lastName == null || lastName.length() < 2 || age < 7 || age > 70)
            throw new IllegalArgumentException("bad student");
        this.id = lastID++;
        this.lastName = lastName;
        this.age = age;
    }

    public Student() {
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("'" + lastName + "'")
                .add("age=" + age)
                .toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return this.lastName.equals(other.lastName) & this.id == other.id;
    }
/*
* The contract between equals() and hashCode() is:
1) If two objects are equal, then they must have the same hash code.
2) If two objects have the same hash code, they may or may not be equal.
*
* it means not fewer fields should be used for equality calculating than hashCode calculating.
*/
    @Override
    public int hashCode() {
        return this.id;
    }

    public static ArrayList<Student> generateStudent(int quantity) {
        if (quantity <= 0 | quantity > 100) throw new IllegalArgumentException("quantity should be 1 to 1000");
        ArrayList<Student> st = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int age = (int) (16 + Math.random() * 40);
            st.add(new Student(generateString(), age));
        }
        return st;
    }

    public static String generateString() {
        int targetStringLength = (int) (3 + Math.random() * 17);
        char[] ch = new char[targetStringLength];
        ch[0] = (char) (65 + Math.random() * (90 - 65));
        for (int i = 1; i < targetStringLength; i++) {
            ch[i] = (char) (97 + Math.random() * (122 - 97));
        }
        return new String(ch);
    }

    public static Comparator<Student> ByAge = (Comparator<Student>) (s1, s2) -> {
        if (s1 != null && s2 != null) {
            return s1.age - s2.age;
        } else return 0;
    };
}
