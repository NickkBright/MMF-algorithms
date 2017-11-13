package com.nickkbright.lab1.sort;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int current, j;

        for (int i = 1; i < arr.length; ++i) {
            current = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                --j;
            }

            arr[j + 1] = current;
        }
    }

}