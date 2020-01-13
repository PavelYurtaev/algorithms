package edu.algorithms.arrays;

import java.util.Objects;

class SimpleArray {

    private final int[] array;

    public SimpleArray(final int[] input) {
        Objects.requireNonNull(input, "Input must not be null");
        array = input;
    }

    public long getMax() {
        if (array.length == 0) return -1;
        long max = array[0];
        for (long item : array) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }


    public int[] removeMax() {
        long max = array[0];
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        for (int i = maxIndex; i < array.length - 1 ; i++) {
            array[i] = array[i + 1];
        }
        int[] result = new int[array.length - 1];
        System.arraycopy(array, 0, result, 0, array.length - 1);
        return result;
    }
}
