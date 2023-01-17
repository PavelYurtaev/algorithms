package edu.algorithms.arrays;

import java.util.Objects;

public class SimpleArray {

    private final int[] array;

    public SimpleArray(final int[] input) {
        Objects.requireNonNull(input, "Input must not be null");
        array = input;
    }

    public int[] bubbleSortRemember() {
        for (int i = 0; i < array.length; i++) {
            printArray();
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                }
            }
        }
        printArray();
        return array;
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
        for (int out = 1; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
        return array;
    }

    public int[] bubbleSortDesc() {
        for (int out = 0; out < array.length; out++) {
            for (int curIndex = array.length - 1; curIndex > out; curIndex--) {
                if (array[curIndex] < array[curIndex - 1]) {
                    int temp = array[curIndex - 1];
                    array[curIndex - 1] = array[curIndex];
                    array[curIndex] = temp;
                }
            }
        }
        printArray();
        return array;
    }

    public int[] insertionSortDesc() {
        int in;
        int temp;
        for (int out = 1; out < array.length; out++) {
            temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] < temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
        return array;
    }


    void printArray() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] shellSort() {
        int in;
        int temp;
        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int out = h; out < array.length; out++) {
                temp = array[out];
                in = out;

                while (in > h - 1 && array[in - h] >= temp) {
                    array[in] = array[in - h];
                    in -= h;
                }
                array[in] = temp;
            }
            h = (h - 1) / 3;
        }
        return array;
    }

    public int[] sortByMerge() {
        sortByMerge(new int[array.length], 0, array.length - 1);
        return array;
    }

    private void sortByMerge(int[] input, int low, int high) {
        if (low != high) {
            int mid = (low + high) / 2;
            sortByMerge(input, low, mid);
            sortByMerge(input, mid + 1, high);
            merge(input, low, mid + 1, high);
        }
    }

    //todo
    private void merge(int[] input, int lowPoint, int highPoint, int upBound) {
        int idx = 0;
        int mid = highPoint - 1;
        int itemsNum = upBound - lowPoint + 1;

        while (lowPoint <= mid && highPoint <= upBound) {
            if (array[lowPoint] < array[highPoint]) {
                input[idx++] = array[lowPoint++];
            } else {
                input[idx++] = array[highPoint++];
            }
        }

        while (lowPoint <= mid) {
            input[idx++] = array[lowPoint++];
        }

        while (highPoint <= upBound) {
            input[idx++] = array[highPoint++];
        }

        System.arraycopy(input, 0, array, lowPoint, itemsNum);
    }

    public int[] quickSort() {
        return quickSort(0, array.length - 1);
    }

    private int[] quickSort(int left, int right) {
        if(right-left <= 0) {
            return array;
        } else {
            int pivot = array[right]; // or median
            int splitIndex = splitByPivot(left, right, pivot);
            quickSort(left, splitIndex - 1);
            quickSort(splitIndex + 1, right);
        }
        return array;
    }

    public int splitByPivot(int left, int right, long pivot) {
        int leftIdx = left - 1;
        int rightIdx = right;
        while(true) {
            while(array[++leftIdx] < pivot ); //find max
            while(rightIdx > 0 && array[--rightIdx] > pivot); //find min

            if(leftIdx >= rightIdx) {
                break;
            } else {
                swap(leftIdx, rightIdx);
            }
        }
        swap(leftIdx, right);
        return leftIdx;
    }

    private void swap(int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

}
