package com.nahorny.collections.myimplementation;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.Iterator;

public class MyTreeSetTest {

    MyTreeSet col0, col1, col2, col3;

    @BeforeClass
    public static void setupAll() {
    }

    @AfterClass
    public static void tearDownAll() {
    }

    @BeforeMethod
    public void setup() {
        col0 = new MyTreeSet();

        col1 = new MyTreeSet();
        col1.add(23);
        col1.add(29);
        col1.add(22);
        col1.add(25);
        col1.add(20);
        col1.add(110);
        col1.add(111);
        col1.add(112);

        col2 = new MyTreeSet();
        col2.add(23);
        col2.add(29);
        col2.add(22);
        col2.add(25);
        col2.add(20);
        col2.add(210);
        col2.add(211);
        col2.add(212);

        col3 = new MyTreeSet();
        col3.add(36);
        col3.add(33);
        col3.add(39);
        col3.add(32);
        col3.add(35);
        col3.add(30);
        col3.add(310);
        col3.add(311);
        col3.add(312);

    }

    @AfterMethod
    public void tearDown() {
        col0 = null;
        col1 = null;
        col2 = null;
        col3 = null;
    }

    @Test
    public void testAddSizeIsEmptyToString() {
        Assert.assertFalse(col2.addAll(col0));
        Assert.assertTrue(col0.isEmpty());
        Assert.assertEquals(col0 + "", "[EMPTY]");
        Assert.assertEquals(0, col0.size());
        Assert.assertTrue(col0.add(36));
        Assert.assertFalse(col3.isEmpty());
        col0.add(33);
        Assert.assertEquals(2, col0.size());
        int tmp = col0.size();
        Assert.assertFalse(col1.add(null));
        Assert.assertEquals(tmp, col0.size());
        Assert.assertEquals( col0 + "", "[33, 36]");
    }

    @Test
    public void testRemoveClear() {
        col1.add(2000);
        int sizeBeforeRemove = col1.size();
        Assert.assertTrue(col1.remove(2000));
        Assert.assertFalse(col1.remove(2000));
        Assert.assertFalse(col1.remove(null));
        Assert.assertEquals(sizeBeforeRemove - 1, col1.size());
        col1.clear();
        Assert.assertEquals(0, col1.size());
        int sizeBefore = col2.size();
        col2.add(29);
        Assert.assertEquals(sizeBefore, col2.size());
    }


    @Test
    public void testContains() {
        Assert.assertFalse(col1.contains(2000));
        col1.add(2000);
        Assert.assertTrue(col1.contains(2000));
        col1.remove(2000);
        Assert.assertFalse(col1.contains(2000));
    }

    @Test
    public void testAddAll() {
        Assert.assertFalse(col2.contains(36));
        Assert.assertFalse(col2.contains(33));
        Assert.assertFalse(col2.contains(39));

        Assert.assertTrue(col2.addAll(col3));
        Assert.assertFalse(col2.addAll(col3));
        Assert.assertFalse(col2.addAll(null));

        Assert.assertTrue(col2.contains(36));
        Assert.assertTrue(col2.contains(33));
        Assert.assertTrue(col2.contains(39));

    }

    @Test
    public void testContainsAll() {
        Assert.assertTrue(col2.containsAll(col0));
        Assert.assertFalse(col2.containsAll(col3));
        Assert.assertTrue(col2.addAll(col3));
        Assert.assertTrue(col2.containsAll(col3));
    }

    @Test
    public void testRemoveAll() {
        Assert.assertFalse(col2.containsAll(col3));
        int sizeBefore2 = col2.size();
        int sizeBefore3 = col3.size();

        Assert.assertTrue(col2.addAll(col3));
        Assert.assertTrue(col2.containsAll(col3));
        Assert.assertEquals(col2.size(), sizeBefore2 + sizeBefore3);
        Assert.assertTrue(col2.removeAll(col3));
        Assert.assertEquals(sizeBefore2, col2.size());
    }

    @Test
    public void testRetainAll() {
        Assert.assertTrue(col2.retainAll(col3));
        Assert.assertFalse(col2.retainAll(col3));
        Assert.assertTrue(col2.isEmpty());

        Assert.assertTrue(col3.retainAll(col0));
        Assert.assertFalse(col0.retainAll(col3));
    }

    @Test
    public void testToArray() {
        Assert.assertTrue(col0.isEmpty());

        Object[] toArr2 = new Object[4];
        col0.toArray(toArr2);

        col0.add(3);
        col0.add(2);
        col0.add(5);
        col0.add(0);

        Object[] toArr = col0.toArray();


        for (Object e : toArr){
            Assert.assertTrue(col0.contains(e));
        }
        col0.toArray(toArr2);
        for (Object e : toArr2){
            Assert.assertTrue(col0.contains(e));
        }
    }

    @Test
    public void testIterator() {

        for (int i = 0; i < 20; i++) {
            int toAdd =(int) (50 * Math.random() * Math.sin(i));
            col0.add(toAdd);
        }

        Object [] ar = col0.toArray();
        Arrays.sort(ar);

        Object [] ar2 = new Object[ar.length];
        int i = 0;

        Iterator it = col0.iterator();
        while (it.hasNext()){
            ar2[i] = it.next();
            i++;
        }

        Assert.assertEquals(col0.size(), ar2.length);
        Assert.assertEquals(col0.size(), ar.length);
        boolean res = true;
        for (int j = 0; j < ar.length - 1; j++) {
            if (ar[j] != ar2[j]) res = false;
        }
        Assert.assertTrue(res);
    }

}//MyTreeSetTest