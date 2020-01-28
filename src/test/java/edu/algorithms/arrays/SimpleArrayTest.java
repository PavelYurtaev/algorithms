package edu.algorithms.arrays;

import org.junit.Ignore;
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

    @Test
    public void bubbleSortTest() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, simpleArray.bubbleSort() );
    }

    @Test
    public void selectionSortTest() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, simpleArray.selectionSort());
    }

    @Test
    public void insertionSortTest() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, simpleArray.insertionSort());
    }

    @Test
    public void bubbleSortDesc() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{18, 14, 13, 9, 8, 7, 5, 3, 2}, simpleArray.bubbleSortDesc());
    }

    @Test
    public void insertionSortDescTest() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{18, 14, 13, 9, 8, 7, 5, 3, 2}, simpleArray.insertionSortDesc());
    }

    @Test
    @Ignore
    public void sortByMergeTest() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, simpleArray.sortByMerge());
    }

    @Test
    public void shellSort() {
        int[] testArr = getTestArray();
        SimpleArray simpleArray = new SimpleArray(testArr);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8, 9, 13, 14, 18}, simpleArray.shellSort());
    }

    @Test
    public void quickSort() {
        SimpleArray simpleArray = new SimpleArray(getTestArray());
        int[] sortedArray = {2, 3, 5, 7, 8, 9, 13, 14, 18};
        assertArrayEquals(sortedArray, simpleArray.quickSort());

        simpleArray = new SimpleArray(sortedArray);
        assertArrayEquals(sortedArray, simpleArray.quickSort());
    }
}