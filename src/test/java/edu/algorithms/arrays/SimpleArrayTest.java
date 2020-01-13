package edu.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArrayTest {

    private int[] getTestArray() {
        return new int[]{2, 18, 5, 14, 8, 3, 7, 13, 9};
    }

    @Test
    public void getMaxTest() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertEquals(18, simpleArray.getMax());
    }

    @Test
    public void removeMaxTest() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{2, 5, 14, 8, 3, 7, 13, 9}, simpleArray.removeMax());
    }
}