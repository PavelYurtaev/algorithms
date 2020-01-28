package edu.algorithms.arrays;

import java.util.Arrays;
import java.util.Objects;

/*
    Immutable ordered array
 */
public class OrderedArray {

    private final int[] array;

    public OrderedArray(final int[] input) {
        Objects.requireNonNull(input, "Input must not be null");
        Arrays.sort(input); // TODO sort manually later
        array = input;
    }

    public int size() {
        return array.length;
    }

    public int[] getArray() {
        return copyArray();
    }

    private int[] copyArray() {
        final int[] resultArray = new int[array.length];
        System.arraycopy(array, 0, resultArray, 0, array.length);
        return resultArray;
    }

    public int findBinary(final int value) {
        int lowBound = 0;
        int highBound = array.length - 1;
        int midIndex;

        while (true) {
            midIndex = (lowBound + highBound) / 2;
            if (array[midIndex] == value) {
                return midIndex;
            } else if (lowBound > highBound) {
                return -1;
            } else if (array[midIndex] < value) {
                lowBound = midIndex + 1;
            } else {
                highBound = midIndex - 1;
            }
        }
    }

    public int findBinaryRecursive(final int value) {
        return findBinaryRecursive(value, 0, array.length - 1);
    }

    private int findBinaryRecursive(final int value, int lowBound, int highBound) {
        int midIndex = (lowBound + highBound) / 2;
        if (array[midIndex] == value) {
            return midIndex;
        } else if (lowBound > highBound) {
            return -1;
        } else if (array[midIndex] < value) {
            return findBinaryRecursive(value, midIndex + 1, highBound);
        } else {
            return findBinaryRecursive(value, lowBound, midIndex - 1);
        }
    }

    public int[] insertLinear(final int value) {
        final int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 0, array.length);

        if (value > result[array.length - 1]) {
            result[result.length - 1] = value;
            return result;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > value) {
                System.arraycopy(array, i, result, i + 1, array.length - i);
                result[i] = value;
                break;
            }
        }
        return result;
    }

    public int[] insertBinary(final int value) {
        final int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 0, array.length);

        int lowBound = 0;
        int highBound = array.length - 1;
        int midIndex;

        while (true) {
            if (lowBound > highBound) {
                System.arraycopy(array, lowBound, result, lowBound + 1, array.length - lowBound);
                result[lowBound] = value;
                return result;
            }
            midIndex = (lowBound + highBound) >>> 1;

            if (array[midIndex] < value) {
                lowBound = midIndex + 1;
            } else {
                highBound = midIndex - 1;
            }
        }
    }

    public int[] delete(int value) {
        int indexToDel = findBinary(value);
        if (indexToDel == -1) { // not found
            return copyArray();
        }
        final int[] result = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i < indexToDel) {
                result[i] = array[i];
            } else {
                System.arraycopy(array, indexToDel + 1, result, indexToDel, result.length - indexToDel);
            }
        }
        return result;
    }

    /*
    TODO
    more than 2 the same numbers
     */
    public int[] removeDups() {
        int[] result = copyArray();
        int inputLength = result.length;

        for (int i = 0; i < inputLength; i++) {
            int checkValue = result[i];
            for (int j = i + 1; j < inputLength; j++) {
                if (checkValue == result[j]) {
                    for (int k = j; k < inputLength - 1; k++) {
                        result[k] = result[k + 1];
                    }
                    inputLength--;
                }
            }
        }
        int[] destination = new int[inputLength];
        System.arraycopy(result, 0, destination, 0, inputLength);
        return destination;
    }

    public int[] merge(int[] inputArr) {
        Arrays.sort(inputArr); // TODO sort manually later

        int[] result = new int[array.length + inputArr.length];

        int i = 0, j = 0, k = 0;
        while (i < array.length && j < inputArr.length) {
            if (array[i] < inputArr[j]) {
                result[k++] = array[i++];
            } else {
                result[k++] = inputArr[j++];
            }
        }
        while (i < array.length) {
            result[k++] = array[i++];
        }
        while (j < inputArr.length) {
            result[k++] = inputArr[j++];
        }
        return result;
    }
}
