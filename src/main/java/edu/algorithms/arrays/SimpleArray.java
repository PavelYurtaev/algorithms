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
        for (int i = maxIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        int[] result = new int[array.length - 1];
        System.arraycopy(array, 0, result, 0, array.length - 1);
        return result;
    }

    public int[] bubbleSort() {
        for (int out = array.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
        }
        return array;
    }

    public int[] selectionSort() {
        int min;
        for (int out = 0; out < array.length - 1; out++) {
            min = out;
            for (int in = out + 1; in < array.length; in++) {
                if (array[in] < array[min]) {
                    min = in;
                }
            }
            int temp = array[out];
            array[out] = array[min];
            array[min] = temp;
        }
        return array;
    }

    public int[] insertionSort() {
        int in;
        for(int out = 1; out < array.length; out++) {
            int temp = array[out];
            // start shifts at out
            in = out;
            while(in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
        return array;
    }
}
