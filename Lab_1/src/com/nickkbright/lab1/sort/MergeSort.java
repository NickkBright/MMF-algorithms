package com.nickkbright.lab1.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        int len = array.length;
        if (len < 2) {
            return array;
        }
        int middle = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(array, 0, middle)),
                mergeSort(Arrays.copyOfRange(array, middle, len)));
    }

    private static int[] merge(int[] arrLeft, int[] arrRight) {
        int lenLeft = arrLeft.length, lenRight = arrRight.length;
        int a = 0, b = 0, len = lenLeft + lenRight; // a, b - счетчики в массивах
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < lenRight && a < lenLeft) {
                if (arrLeft[a] > arrRight[b]) {
                    result[i] = arrRight[b];
                    b++;
                }
                else {
                    result[i] = arrLeft[a];
                    a++;
                }
            } else if (b < lenRight) {
                result[i] = arrRight[b];
                b++;
            } else {
                result[i] = arrLeft[a];
                a++;
            }
        }
        return result;
    }
}