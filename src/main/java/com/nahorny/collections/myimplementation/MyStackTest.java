package com.nahorny.collections.myimplementation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

public class MyStackTest {
    MyStack st;

    @BeforeMethod
    public void setup() {
        st = new MyStack();
        for (int i = 0; i <= 6; st.push(i++)) {
        }
    }

    @AfterMethod
    public void tearDown() {
       st = null;
    }

    @Test
    public void testStack() {
        Assert.assertEquals(st.toString(), "[6, 5, 4, 3, 2, 1, 0]");
        Assert.assertEquals(st.peek(), 6);
        Assert.assertEquals(st.toString(), "[6, 5, 4, 3, 2, 1, 0]");
        Assert.assertEquals(st.pop(), 6);
        Assert.assertEquals(st.toString(), "[5, 4, 3, 2, 1, 0]");
        for (int i = 5; i >= 1; st.pop(), i--) {
        }
        Assert.assertEquals(st.pop(), 0);
        boolean emptyStackExceptionOK = false;
        try {
            st.pop();
        } catch (EmptyStackException e) {
            emptyStackExceptionOK = true;
        }
        Assert.assertTrue(emptyStackExceptionOK);
    }
}
