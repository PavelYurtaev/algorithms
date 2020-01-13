package edu.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedArrayTest {

    private int[] getTestArray() {
        return new int[]{2, 18, 5, 14, 8, 3, 7, 13, 9};
    }

    @Test
    public void autoOrderTest() {
        int[] testArr = getTestArray();
        OrderedArray orderedArray = new OrderedArray(testArr);
        assertEquals(testArr.length, orderedArray.size());
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, orderedArray.getArray());
    }
    @Test
    public void findBinaryTest() {
        int[] testArr = getTestArray();
        OrderedArray orderedArray = new OrderedArray(testArr);
        assertEquals(2, orderedArray.findBinary(5));
        assertEquals(-1, orderedArray.findBinary(22));
    }

    @Test
    public void insertLinearTest() {
        int[] testArr = getTestArray();
        OrderedArray orderedArray = new OrderedArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 10, 13, 14, 18}, orderedArray.insertLinear(10));
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 8, 9, 13, 14, 18}, orderedArray.insertLinear(1));
        assertArrayEquals(new int[]{-5, 2, 3, 5, 7, 8, 9, 13, 14, 18}, orderedArray.insertLinear(-5));
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18, 20}, orderedArray.insertLinear(20));
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 9, 13, 14, 18}, orderedArray.insertLinear(9));

        OrderedArray emptyArray = new OrderedArray(new int[2]);
        assertArrayEquals(new int[]{0, 0, 10}, emptyArray.insertLinear(10));
    }

    @Test
    public void insertBinaryTest() {
        int[] testArr = getTestArray();
        OrderedArray orderedArray = new OrderedArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 10, 13, 14, 18}, orderedArray.insertBinary(10));
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 8, 9, 13, 14, 18}, orderedArray.insertBinary(1));
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18, 20}, orderedArray.insertBinary(20));
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 9, 13, 14, 18}, orderedArray.insertBinary(9));

        OrderedArray emptyArray = new OrderedArray(new int[2]);
        assertArrayEquals(new int[]{0, 0, 10}, emptyArray.insertBinary(10));
    }

    @Test
    public void deleteTest() {
        int[] testArr = getTestArray();
        OrderedArray orderedArray = new OrderedArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 9, 13, 14, 18}, orderedArray.delete(8));
        assertArrayEquals(new int[]{3, 5, 7, 8, 9, 13, 14, 18}, orderedArray.delete(2));
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14}, orderedArray.delete(18));
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, orderedArray.delete(22));

        OrderedArray emptyArray = new OrderedArray(new int[2]);
        assertArrayEquals(new int[]{0, 0}, emptyArray.delete(10));
    }

    @Test
    public void removeDupsTest() {
        int[] testArr = new int[]{2, 18, 5, 18, 14, 8, -3, 7, -3, 13, 9, 9};
        OrderedArray orderedArray = new OrderedArray(testArr);
        assertArrayEquals(new int[]{-3, -3, 2, 5, 7, 8, 9, 9, 13, 14, 18, 18}, orderedArray.getArray());
        assertArrayEquals(new int[]{-3, 2, 5, 7, 8, 9, 13, 14, 18}, orderedArray.removeDups());

        orderedArray = new OrderedArray(getTestArray()); // no dups
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, orderedArray.removeDups());
    }

    @Test
    public void mergeTest() {
        int[] testArr = new int[]{2, 3, 5, 7, 9, 13, 14, 18};
        OrderedArray orderedArray = new OrderedArray(testArr);

        int[] toMergeArr = new int[]{10, 27, 16, 99};
        assertArrayEquals(new int[]{2, 3, 5, 7, 9, 10, 13, 14, 16, 18, 27, 99}, orderedArray.merge(toMergeArr));
        assertArrayEquals(new int[]{0, 0, 2, 3, 5, 7, 9, 13, 14, 18}, orderedArray.merge(new int[2]));
    }
}